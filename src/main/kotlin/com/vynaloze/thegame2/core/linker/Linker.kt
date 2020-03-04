package com.vynaloze.thegame2.core.linker

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Object


interface Linker {
    fun findObjectsOn(node: Node): List<Object>
    fun findPositionOf(obj: Object): Node

    fun moveObject(obj: Object, target: Node)
}