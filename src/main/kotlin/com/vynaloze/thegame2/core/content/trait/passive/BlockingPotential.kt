package com.vynaloze.thegame2.core.content.trait.passive


interface BlockingPotential {
    val blocksMovement: Boolean
    val blocksAttack: Boolean
    val blocksSpells: Boolean
}