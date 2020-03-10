package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.trait.Combative
import com.vynaloze.thegame2.core.content.trait.Vulnerable
import com.vynaloze.thegame2.core.engine.exception.AttackTargetNotVulnerableException
import com.vynaloze.thegame2.core.engine.exception.AttackTargetOutOfRangeException
import com.vynaloze.thegame2.core.linker.Linker


class CombatEngine(private val linker: Linker) {
    fun <T> attack(source: T, target: Node) where T : Thing, T : Combative {
        val position = this.linker.findPositionOf(source)
        val range = source.attackRange.evaluate(position)
        if (target !in range) {
            throw AttackTargetOutOfRangeException("target node $target is out of attack range of thing $this ($range)")
        }

        val thingsOnTarget = this.linker.findObjectsOn(target)
        val allVulnerableThingsOnTarget = thingsOnTarget.filterIsInstance<Vulnerable>()
        if (allVulnerableThingsOnTarget.isEmpty()) {
            throw AttackTargetNotVulnerableException("target node $target contains no vulnerable things")
        }

        allVulnerableThingsOnTarget.forEach { t -> t.damage(source.attackForce) }
    }
}