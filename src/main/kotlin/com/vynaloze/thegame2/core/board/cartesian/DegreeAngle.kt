package com.vynaloze.thegame2.core.board.cartesian

import com.vynaloze.thegame2.core.board.Angle


enum class DegreeAngle(val value: Double): Angle {
    RIGHT(0.0), UP(90.0), LEFT(180.0), DOWN(270.0);

    override fun opposite(): Angle {
        return when(this) {
            RIGHT -> LEFT
            UP -> DOWN
            LEFT -> RIGHT
            DOWN -> UP
        }
    }
}
