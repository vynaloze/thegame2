package com.vynaloze.thegame2.core.content.trait.passive

import com.vynaloze.thegame2.core.content.property.Health
import com.vynaloze.thegame2.core.content.property.Range


interface CombatPotential {
    val attackRange: Range
    val attackForce: Health
}