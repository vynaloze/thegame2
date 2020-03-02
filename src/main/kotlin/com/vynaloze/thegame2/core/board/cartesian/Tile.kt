package com.vynaloze.thegame2.core.board.cartesian

import com.vynaloze.thegame2.core.board.Angle
import com.vynaloze.thegame2.core.board.Coordinate
import com.vynaloze.thegame2.core.board.Edge
import com.vynaloze.thegame2.core.board.Node


data class Tile(override val coordinates: List<Coordinate>, override val edges: List<Edge>) : Node {

    override fun findEdgeBy(angle: Angle): Edge? {
        return this.edges.stream()
                .filter { e -> e.angle == angle}
                .findFirst().get()
    }

    override fun add(vararg edges: Edge): Node {
        return Tile(this.coordinates, this.edges + edges)
    }
}