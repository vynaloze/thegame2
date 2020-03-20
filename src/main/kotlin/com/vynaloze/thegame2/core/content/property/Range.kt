package com.vynaloze.thegame2.core.content.property

import com.vynaloze.thegame2.core.board.Angle
import com.vynaloze.thegame2.core.board.Node


interface Range {
    fun evaluate(position: Node, rotation: Angle): List<Node>
}
