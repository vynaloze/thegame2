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
import com.vynaloze.thegame2.core.engine.CombatEngine
import com.vynaloze.thegame2.core.engine.DamageEngine
import com.vynaloze.thegame2.core.engine.MoveEngine
import com.vynaloze.thegame2.core.engine.SorceryEngine


class Monster(
        override val name: String,
        override val owner: Owner,
        private val combatPotential: CombatPotential,
        private val combatEngine: CombatEngine,
        private val movablePotential: MovablePotential,
        private val moveEngine: MoveEngine,
        private val damageablePotential: DamageablePotential,
        private val damageEngine: DamageEngine,
        private val sorcerousPotential: SorcerousPotential,
        private val sorceryEngine: SorceryEngine,
        private val blockingPotential: Blocking
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
        Blocking by blockingPotential {

    override fun attack(target: Node) {
        return this.combatEngine.attack(this, target)
    }

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

    override fun invoke(spell: Spell) {
        return this.sorceryEngine.invoke(this, spell)
    }

    override fun invoke(spell: Spell, vararg target: Node) {
        return this.sorceryEngine.invoke(this, spell, *target)
    }

    override fun invoke(spell: Spell, vararg target: Thing) {
        return this.sorceryEngine.invoke(this, spell, *target)
    }
}