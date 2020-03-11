package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.trait.active.Combative
import com.vynaloze.thegame2.core.content.trait.active.Damageable
import com.vynaloze.thegame2.core.engine.exception.AttackTargetNotDamageableException
import com.vynaloze.thegame2.core.engine.exception.AttackTargetOutOfRangeException
import com.vynaloze.thegame2.core.linker.Linker


class CombatEngine(linker: Linker) : Engine(linker) {
    fun <T> attack(source: T, target: Node) where T : Thing, T : Combative {
        val position = this.linker.findPositionOf(source)
        val range = source.attackRange.evaluate(position)
        if (target !in range) {
            throw AttackTargetOutOfRangeException("target node $target is out of attack range of thing $this ($range)")
        }

        val thingsOnTarget = this.linker.findObjectsOn(target)
        val allDamageableThingsOnTarget = thingsOnTarget.filterIsInstance<Damageable>()
        if (allDamageableThingsOnTarget.isEmpty()) {
            throw AttackTargetNotDamageableException("target node $target contains no damageable things")
        }

        allDamageableThingsOnTarget.forEach { t -> t.damage(source.attackForce) }
    }
}