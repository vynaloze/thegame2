package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.trait.active.Damageable
import com.vynaloze.thegame2.core.engine.exception.ThingIsAlreadyDeadException
import com.vynaloze.thegame2.core.content.property.Health
import com.vynaloze.thegame2.core.linker.Linker


class DamageEngine(linker: Linker) : Engine(linker) {
    fun <T> damage(target: T, health: Health) where T : Thing, T: Damageable {
        if (this.isDead(target)) {
            throw ThingIsAlreadyDeadException("thing $this is already dead")
        }
        target.health.decrease(health)
        if (this.isDead(target)) {
            this.linker.removeThing(target)
        }
    }

    fun <T> restore(target: T, health: Health) where T : Thing, T: Damageable {
        if (this.isDead(target)) {
            throw ThingIsAlreadyDeadException("thing $this is already dead")
        }
        target.health.increase(health)
    }

    fun <T> isDead(target: T): Boolean where T : Thing, T: Damageable {
        return target.health.isDepleted()
    }
}