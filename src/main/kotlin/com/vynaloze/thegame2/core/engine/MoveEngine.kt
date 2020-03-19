package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.trait.passive.Blocking
import com.vynaloze.thegame2.core.content.trait.active.Movable
import com.vynaloze.thegame2.core.engine.exception.MoveTargetIsBlockedException
import com.vynaloze.thegame2.core.engine.exception.MoveTargetOutOfRangeException
import com.vynaloze.thegame2.core.linker.Linker


class MoveEngine(linker: Linker) : Engine(linker) {
    fun <T> move(source: T, target: Node) where T: Thing, T: Movable {
        val position = this.linker.findPositionOf(source)
        val range = source.moveRange.evaluate(position)
        if (target !in range) {
            throw MoveTargetOutOfRangeException("target node $target is out of range of thing $this ($range)")
        }

        val thingsOnTarget = this.linker.findObjectsOn(target)
        val firstBlockingThingOnTarget = thingsOnTarget.find { t -> t is Blocking && t.blocksMovement }
        if (firstBlockingThingOnTarget != null) {
            throw MoveTargetIsBlockedException("target node $target is blocked by $firstBlockingThingOnTarget")
        }

        this.linker.moveThing(source, target)
    }
}