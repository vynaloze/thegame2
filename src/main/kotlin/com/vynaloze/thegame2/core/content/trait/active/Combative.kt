package com.vynaloze.thegame2.core.content.trait.active

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.trait.passive.CombatPotential


interface Combative: CombatPotential {
    fun attack(target: Node)
}