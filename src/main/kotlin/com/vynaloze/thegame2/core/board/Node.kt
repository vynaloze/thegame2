package com.vynaloze.thegame2.core.board


interface Node {
    val coordinates: List<Coordinate>
    val edges: List<Edge>

    fun findEdgeBy(angle: Angle): Edge?

    fun add(vararg edges: Edge): Node
}