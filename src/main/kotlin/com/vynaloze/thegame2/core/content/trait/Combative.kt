package com.vynaloze.thegame2.core.content.trait

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.property.Health
import com.vynaloze.thegame2.core.content.property.Range


interface Combative {
    val attackRange: Range
    val attackForce: Health

    fun attack(target: Node)
}