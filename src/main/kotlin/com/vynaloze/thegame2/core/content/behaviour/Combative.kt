package com.vynaloze.thegame2.core.content.behaviour

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.property.Range


interface Combative {
    val attackRange: Range

    fun attack(target: Node)
}