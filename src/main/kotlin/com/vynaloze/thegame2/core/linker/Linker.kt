package com.vynaloze.thegame2.core.linker

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing


interface Linker {
    fun findObjectsOn(node: Node): List<Thing>
    fun findPositionOf(thing: Thing): Node

    fun moveThing(thing: Thing, target: Node)
    fun removeThing(thing: Thing)
}