package com.vynaloze.thegame2.core.content.trait.active

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Spell
import com.vynaloze.thegame2.core.content.trait.passive.SorcerousPotential


interface Sorcerous: SorcerousPotential {
    fun invoke(spell: Spell)
    fun invoke(spell: Spell, vararg target: Node)
    fun invoke(spell: Spell, vararg target: Thing)
}