package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.trait.passive.BlockingPotential
import com.vynaloze.thegame2.core.engine.exception.CreationTargetIsBlockedException
import com.vynaloze.thegame2.core.factory.ThingFactory
import com.vynaloze.thegame2.core.linker.Linker
import kotlin.reflect.KClass


class CreationEngine(linker: Linker, private val thingFactory: ThingFactory) : Engine(linker) {
    fun <T : Thing> create(thing: Thing, thingType: KClass<T>, target: Node): T {
        val thingsOnTarget = this.linker.findObjectsOn(target)
        val firstBlockingThingOnTarget = thingsOnTarget.find { t -> t is BlockingPotential && t.blocksMovement }
        if (firstBlockingThingOnTarget != null) {
            throw CreationTargetIsBlockedException("target node $target is blocked by $firstBlockingThingOnTarget")
        }
        return this.thingFactory.create(thing, thingType, target)
    }
}