package com.vynaloze.thegame2.core.linker

import com.vynaloze.thegame2.core.board.Angle
import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing


interface Linker {
    fun findObjectsOn(node: Node): List<Thing>
    fun findPositionOf(thing: Thing): Position

    fun moveThing(thing: Thing, target: Node)
    fun rotateThing(thing: Thing, angle: Angle)
    fun createThing(thing: Thing, position: Position)
    fun removeThing(thing: Thing)
}