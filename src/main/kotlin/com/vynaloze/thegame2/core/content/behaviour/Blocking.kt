package com.vynaloze.thegame2.core.content.behaviour


interface Blocking {
    val blocksMovement: Boolean
    val blocksAttack: Boolean
    val blocksSpells: Boolean
}