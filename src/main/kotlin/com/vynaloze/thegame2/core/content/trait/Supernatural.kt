package com.vynaloze.thegame2.core.content.trait

import com.vynaloze.thegame2.core.content.property.Spell


interface Supernatural : Trait {
    val spells: List<Spell>
}