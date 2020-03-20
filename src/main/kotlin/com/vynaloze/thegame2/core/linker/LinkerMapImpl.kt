package com.vynaloze.thegame2.core.linker

import com.vynaloze.thegame2.core.board.Angle
import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock


class LinkerMapImpl(private var map: Map<Thing, Position>) : Linker {
    private val lock = ReentrantLock()

    override fun findObjectsOn(node: Node): List<Thing> {
        return map
                .filter { (_, n) -> n.node == node }
                .map { (thing, _) -> thing }
    }

    override fun findPositionOf(thing: Thing): Position {
        return map[thing] ?: throw ThingDoesNotExistException("position of thing $thing not found")
    }

    override fun moveThing(thing: Thing, target: Node) {
        lock.withLock {
            val currentPosition = findPositionOf(thing)
            val newMap = map.toMutableMap()
            newMap.replace(thing, Position(target, currentPosition.rotation)) ?: throw ThingDoesNotExistException("cannot move not-existing thing $thing")
            // todo validate rules? - if object can be moved to target node
            map = newMap
        }
    }

    override fun rotateThing(thing: Thing, angle: Angle) {
        lock.withLock {
            val currentPosition = findPositionOf(thing)
            val newMap = map.toMutableMap()
            newMap.replace(thing, Position(currentPosition.node, angle)) ?: throw ThingDoesNotExistException("cannot rotate not-existing thing $thing")
            map = newMap
        }
    }

    override fun createThing(thing: Thing, position: Position) {
        lock.withLock {
            val newMap = map.toMutableMap()
            newMap[thing] = position
            map = newMap
        }
    }

    override fun removeThing(thing: Thing) {
        lock.withLock {
            val newMap = map.toMutableMap()
            newMap.remove(thing) ?: throw ThingDoesNotExistException("cannot remove not-existing thing $thing")
            map = newMap
        }
    }
}