package com.vynaloze.thegame2.core.linker

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Object
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock


class LinkerMapImpl(private var map: Map<Object, Node>) : Linker {
    private val lock = ReentrantLock()

    override fun findObjectsOn(node: Node): List<Object> {
        return map
                .filter { (_, n) -> n == node }
                .map { (obj, _) -> obj }
    }

    override fun findPositionOf(obj: Object): Node {
        return map[obj] ?: throw ObjectDoesNotExistException("position of object $obj not found")
    }

    override fun moveObject(obj: Object, target: Node) {
        lock.withLock {
            val newMap = map.toMutableMap()
            newMap.replace(obj, target) ?: throw ObjectDoesNotExistException("cannot remove not-existing object $obj")
            // todo validate rules? - if object can be moved to target node
            map = newMap
        }
    }

}