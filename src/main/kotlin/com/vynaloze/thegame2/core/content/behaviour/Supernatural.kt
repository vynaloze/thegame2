package com.vynaloze.thegame2.core.content.behaviour

import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Spell


interface Supernatural: Thing {
    val spells : List<Spell>
}