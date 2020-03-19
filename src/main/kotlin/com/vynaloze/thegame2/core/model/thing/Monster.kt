package com.vynaloze.thegame2.core.model.thing

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Health
import com.vynaloze.thegame2.core.content.property.Owner
import com.vynaloze.thegame2.core.content.property.Spell
import com.vynaloze.thegame2.core.content.trait.active.Combative
import com.vynaloze.thegame2.core.content.trait.active.Damageable
import com.vynaloze.thegame2.core.content.trait.active.Movable
import com.vynaloze.thegame2.core.content.trait.active.Sorcerous
import com.vynaloze.thegame2.core.content.trait.passive.*
import com.vynaloze.thegame2.core.engine.*


class Monster(
        override val name: String,
        override val owner: Owner,
        private val combatPotential: CombatPotential,
        private val movablePotential: MovablePotential,
        private val damageablePotential: DamageablePotential,
        private val sorcerousPotential: SorcerousPotential,
        private val blockingPotentialPotential: BlockingPotential,
        private val engineProvider: EngineProvider
) :
        Thing,
        CombatPotential by combatPotential,
        Combative,
        MovablePotential by movablePotential,
        Movable,
        DamageablePotential by damageablePotential,
        Damageable,
        SorcerousPotential by sorcerousPotential,
        Sorcerous,
        BlockingPotential by blockingPotentialPotential {

    override fun attack(target: Node) {
        return this.engineProvider.combatEngine.attack(this, target)
    }

    override fun move(target: Node) {
        return this.engineProvider.moveEngine.move(this, target)
    }

    override fun damage(health: Health) {
        return this.engineProvider.damageEngine.damage(this, health)
    }

    override fun restore(health: Health) {
        return this.engineProvider.damageEngine.restore(this, health)
    }

    override fun isDead(): Boolean {
        return this.engineProvider.damageEngine.isDead(this)
    }

    override fun invoke(spell: Spell, target: Node) {
        return this.engineProvider.sorceryEngine.invoke(this, spell, target)
    }
}