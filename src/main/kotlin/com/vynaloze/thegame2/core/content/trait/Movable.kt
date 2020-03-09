package com.vynaloze.thegame2.core.content.trait

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.property.Range


interface Movable : Trait {
    val moveRange: Range

    fun move(target: Node)
}
