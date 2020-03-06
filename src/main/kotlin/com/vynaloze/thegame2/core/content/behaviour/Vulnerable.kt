package com.vynaloze.thegame2.core.content.behaviour

import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Health


interface Vulnerable: Thing {
    val health: Health

    fun damage(health: Health)
    fun restore(health: Health)
    fun isDead(): Boolean
}