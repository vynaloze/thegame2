package com.vynaloze.thegame2.core.model.thing

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Health
import com.vynaloze.thegame2.core.content.property.Owner
import com.vynaloze.thegame2.core.content.trait.active.Damageable
import com.vynaloze.thegame2.core.content.trait.active.Movable
import com.vynaloze.thegame2.core.content.trait.passive.Blocking
import com.vynaloze.thegame2.core.content.trait.passive.DamageablePotential
import com.vynaloze.thegame2.core.content.trait.passive.MovablePotential
import com.vynaloze.thegame2.core.engine.DamageEngine
import com.vynaloze.thegame2.core.engine.MoveEngine


class Stone(
        override val name: String,
        override val owner: Owner,
        private val movablePotential: MovablePotential,
        private val moveEngine: MoveEngine,
        private val damageablePotential: DamageablePotential,
        private val damageEngine: DamageEngine,
        private val blockingPotential: Blocking
) :
        Thing,
        MovablePotential by movablePotential,
        Movable,
        DamageablePotential by damageablePotential,
        Damageable,
        Blocking by blockingPotential {

    override fun move(target: Node) {
        return this.moveEngine.move(this, target)
    }

    override fun damage(health: Health) {
        return this.damageEngine.damage(this, health)
    }

    override fun restore(health: Health) {
        return this.damageEngine.restore(this, health)
    }

    override fun isDead(): Boolean {
        return this.damageEngine.isDead(this)
    }
}