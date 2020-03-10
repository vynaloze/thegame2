package com.vynaloze.thegame2.core.content.trait

import com.vynaloze.thegame2.core.content.property.Health


interface Vulnerable {
    val health: Health

    fun damage(health: Health)
    fun restore(health: Health)
    fun isDead(): Boolean
}
