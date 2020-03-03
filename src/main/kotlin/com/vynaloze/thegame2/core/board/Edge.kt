package com.vynaloze.thegame2.core.board


interface Edge {
    val source: Node
    val angle: Angle
    val target: Node
}