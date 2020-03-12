package com.vynaloze.thegame2.core.board.cartesian

import com.vynaloze.thegame2.core.board.BoardTestBase
import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.board.Edge

class GridTest : BoardTestBase() {

    override fun generateTestCases(): List<TestCase> = prepareTestCases().map { f -> f() }

    private fun prepareTestCases(): List<() -> TestCase> {
        return listOf({
            val expectedNodes = listOf(
                    Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 0)),
                    Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 0)),
                    Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 1)),
                    Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 1))
            )
            val expectedEdges = mapOf(
                    expectedNodes[0] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[1]),
                            TileEdge(DegreeAngle.UP, expectedNodes[2])
                    ),
                    expectedNodes[1] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.LEFT, expectedNodes[0]),
                            TileEdge(DegreeAngle.UP, expectedNodes[3])
                    ),
                    expectedNodes[2] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[0]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[3])
                    ),
                    expectedNodes[3] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[1]),
                            TileEdge(DegreeAngle.LEFT, expectedNodes[2])
                    )
            )
            TestCase("2x2", Grid(2, 2), expectedNodes, expectedEdges)
        }, {
            val expectedNodes = listOf(
                    Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 0)),
                    Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 0)),
                    Tile(CartesianCoordinate(Dimension.X, 2), CartesianCoordinate(Dimension.Y, 0)),
                    Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 1)),
                    Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 1)),
                    Tile(CartesianCoordinate(Dimension.X, 2), CartesianCoordinate(Dimension.Y, 1))
            )
            val expectedEdges = mapOf(
                    expectedNodes[0] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[1]),
                            TileEdge(DegreeAngle.UP, expectedNodes[3])
                    ),
                    expectedNodes[1] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.LEFT, expectedNodes[0]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[2]),
                            TileEdge(DegreeAngle.UP, expectedNodes[4])
                    ),
                    expectedNodes[2] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.LEFT, expectedNodes[1]),
                            TileEdge(DegreeAngle.UP, expectedNodes[5])
                    ),
                    expectedNodes[3] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[0]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[4])
                    ),
                    expectedNodes[4] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[1]),
                            TileEdge(DegreeAngle.LEFT, expectedNodes[3]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[5])
                    ),
                    expectedNodes[5] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.LEFT, expectedNodes[4]),
                            TileEdge(DegreeAngle.DOWN, expectedNodes[2])
                    )
            )
            TestCase("3x2", Grid(3, 2), expectedNodes, expectedEdges)
        }, {
            val expectedNodes = listOf(
                    Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 0)),
                    Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 0)),
                    Tile(CartesianCoordinate(Dimension.X, 2), CartesianCoordinate(Dimension.Y, 0)),
                    Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 1)),
                    Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 1)),
                    Tile(CartesianCoordinate(Dimension.X, 2), CartesianCoordinate(Dimension.Y, 1)),
                    Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 2)),
                    Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 2)),
                    Tile(CartesianCoordinate(Dimension.X, 2), CartesianCoordinate(Dimension.Y, 2)),
                    Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 3)),
                    Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 3)),
                    Tile(CartesianCoordinate(Dimension.X, 2), CartesianCoordinate(Dimension.Y, 3))
            )
            val expectedEdges = mapOf(
                    expectedNodes[0] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[1]),
                            TileEdge(DegreeAngle.UP, expectedNodes[3])
                    ),
                    expectedNodes[1] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.LEFT, expectedNodes[0]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[2]),
                            TileEdge(DegreeAngle.UP, expectedNodes[4])
                    ),
                    expectedNodes[2] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.LEFT, expectedNodes[1]),
                            TileEdge(DegreeAngle.UP, expectedNodes[5])
                    ),
                    expectedNodes[3] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[0]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[4]),
                            TileEdge(DegreeAngle.UP, expectedNodes[6])
                    ),
                    expectedNodes[4] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[1]),
                            TileEdge(DegreeAngle.LEFT, expectedNodes[3]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[5]),
                            TileEdge(DegreeAngle.UP, expectedNodes[7])
                    ),
                    expectedNodes[5] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.LEFT, expectedNodes[4]),
                            TileEdge(DegreeAngle.DOWN, expectedNodes[2]),
                            TileEdge(DegreeAngle.UP, expectedNodes[8])
                    ),
                    expectedNodes[6] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[3]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[7]),
                            TileEdge(DegreeAngle.UP, expectedNodes[9])
                    ),
                    expectedNodes[7] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[4]),
                            TileEdge(DegreeAngle.LEFT, expectedNodes[6]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[8]),
                            TileEdge(DegreeAngle.UP, expectedNodes[10])
                    ),
                    expectedNodes[8] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[5]),
                            TileEdge(DegreeAngle.LEFT, expectedNodes[7]),
                            TileEdge(DegreeAngle.UP, expectedNodes[11])
                    ),
                    expectedNodes[9] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[6]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[10])
                    ),
                    expectedNodes[10] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[7]),
                            TileEdge(DegreeAngle.LEFT, expectedNodes[9]),
                            TileEdge(DegreeAngle.RIGHT, expectedNodes[11])
                    ),
                    expectedNodes[11] as Node to listOf<Edge>(
                            TileEdge(DegreeAngle.DOWN, expectedNodes[8]),
                            TileEdge(DegreeAngle.LEFT, expectedNodes[10])
                    )
            )
            TestCase("3x4", Grid(3, 4), expectedNodes, expectedEdges)
        })
    }
}