package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.behaviour.Blocking
import com.vynaloze.thegame2.core.content.behaviour.Movable
import com.vynaloze.thegame2.core.content.behaviour.exception.MoveTargetIsBlockedException
import com.vynaloze.thegame2.core.content.behaviour.exception.MoveTargetOutOfRangeException
import com.vynaloze.thegame2.core.linker.Linker


abstract class MoveEngine(private val linker: Linker) : Movable {
    override fun move(target: Node) {
        val position = this.linker.findPositionOf(this.container)
        val range = this.moveRange.evaluate(position)
        if (target !in range) {
            throw MoveTargetOutOfRangeException("target node $target is out of range of thing $this ($range)")
        }

        val thingsOnTarget = this.linker.findObjectsOn(target)
        val firstBlockingThingOnTarget = thingsOnTarget.find { t -> t is Blocking }
        if (firstBlockingThingOnTarget != null) {
            throw MoveTargetIsBlockedException("target node $target is blocked by $firstBlockingThingOnTarget")
        }

        this.linker.moveThing(this.container, target)
    }
}