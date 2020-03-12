package com.vynaloze.thegame2.core.board.cartesian

import com.vynaloze.thegame2.core.board.Edge


data class TileEdge(override val angle: DegreeAngle, override val target: Tile) : Edge
