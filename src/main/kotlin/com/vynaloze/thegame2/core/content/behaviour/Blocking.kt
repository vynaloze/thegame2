package com.vynaloze.thegame2.core.content.behaviour

import com.vynaloze.thegame2.core.content.Thing


interface Blocking: Thing {
    val blocksMovement: Boolean
    val blocksAttack: Boolean
    val blocksSpells: Boolean
}