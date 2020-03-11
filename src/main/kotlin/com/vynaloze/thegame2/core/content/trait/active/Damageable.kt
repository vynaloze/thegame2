package com.vynaloze.thegame2.core.content.trait.active

import com.vynaloze.thegame2.core.content.property.Health
import com.vynaloze.thegame2.core.content.trait.passive.DamageablePotential


interface Damageable: DamageablePotential {
    fun damage(health: Health)
    fun restore(health: Health)
    fun isDead(): Boolean
}
