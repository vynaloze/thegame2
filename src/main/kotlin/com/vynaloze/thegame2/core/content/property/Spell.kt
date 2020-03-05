package com.vynaloze.thegame2.core.content.property

import com.vynaloze.thegame2.core.content.Thing


interface Spell {
    val name: String
    val cost: Mana
    val effectArea: Range

    fun invoke()
    fun invoke(target: Thing)
}