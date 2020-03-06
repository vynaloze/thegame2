package com.vynaloze.thegame2.core.content.behaviour

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Health
import com.vynaloze.thegame2.core.content.property.Range


interface Combative: Thing {
    val attackRange: Range
    val attackForce: Health

    fun attack(target: Node)
}