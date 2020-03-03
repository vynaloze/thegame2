package com.vynaloze.thegame2.core.board.cartesian

import com.vynaloze.thegame2.core.board.Node


data class Tile(override val coordinates: List<CartesianCoordinate>) : Node {
    constructor(x: CartesianCoordinate, y: CartesianCoordinate) : this(listOf(x, y))
}
