package com.vynaloze.thegame2.core.content.behaviour

import com.vynaloze.thegame2.core.content.property.Spell


interface Supernatural : Trait {
    val spells: List<Spell>
}