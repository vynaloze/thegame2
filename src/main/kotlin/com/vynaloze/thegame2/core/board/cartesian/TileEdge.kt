package com.vynaloze.thegame2.core.board.cartesian

import com.vynaloze.thegame2.core.board.Edge


data class TileEdge(override val source: Tile, override val angle: DegreeAngle, override val target: Tile) : Edge
