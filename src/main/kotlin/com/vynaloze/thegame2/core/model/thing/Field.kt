package com.vynaloze.thegame2.core.model.thing

import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Owner
import com.vynaloze.thegame2.core.content.trait.passive.Blocking


class Field(
        override val name: String,
        override val owner: Owner,
        private val blockingPotential: Blocking
) :
        Thing,
        Blocking by blockingPotential {
}