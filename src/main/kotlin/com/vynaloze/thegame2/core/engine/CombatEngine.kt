package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.trait.Combative
import com.vynaloze.thegame2.core.content.trait.Vulnerable
import com.vynaloze.thegame2.core.engine.exception.AttackTargetNotVulnerableException
import com.vynaloze.thegame2.core.engine.exception.AttackTargetOutOfRangeException
import com.vynaloze.thegame2.core.linker.Linker


abstract class CombatEngine(private val linker: Linker) : Combative {
    override fun attack(target: Node) {
        val position = this.linker.findPositionOf(this.container)
        val range = this.attackRange.evaluate(position)
        if (target !in range) {
            throw AttackTargetOutOfRangeException("target node $target is out of attack range of thing $this ($range)")
        }

        val thingsOnTarget = this.linker.findObjectsOn(target)
        val allVulnerableThingsOnTarget = thingsOnTarget.filterIsInstance<Vulnerable>()
        if (allVulnerableThingsOnTarget.isEmpty()) {
            throw AttackTargetNotVulnerableException("target node $target contains no vulnerable things")
        }

        allVulnerableThingsOnTarget.forEach { t -> t.damage(this.attackForce) }
    }
}