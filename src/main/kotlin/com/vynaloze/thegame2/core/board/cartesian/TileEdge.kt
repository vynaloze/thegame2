package com.vynaloze.thegame2.core.board.cartesian

import com.vynaloze.thegame2.core.board.Angle
import com.vynaloze.thegame2.core.board.Edge
import com.vynaloze.thegame2.core.board.Node


data class TileEdge(override val angle: Angle, override val target: Node) : Edge
