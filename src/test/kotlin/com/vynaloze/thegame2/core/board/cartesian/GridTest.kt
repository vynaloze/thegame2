package com.vynaloze.thegame2.core.board.cartesian

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class GridTest {
    @Test
    fun `should generate 2x2 grid`() {
        // given
        val width = 2
        val height = 2

        val expectedNodes = listOf(
                Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 0)),
                Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 0)),
                Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 1)),
                Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 1))
        )

        val expectedEdges = listOf(
                TileEdge(expectedNodes[0], DegreeAngle.RIGHT, expectedNodes[1]),
                TileEdge(expectedNodes[1], DegreeAngle.LEFT, expectedNodes[0]),

                TileEdge(expectedNodes[0], DegreeAngle.UP, expectedNodes[2]),
                TileEdge(expectedNodes[2], DegreeAngle.DOWN, expectedNodes[0]),

                TileEdge(expectedNodes[1], DegreeAngle.UP, expectedNodes[3]),
                TileEdge(expectedNodes[3], DegreeAngle.DOWN, expectedNodes[1]),

                TileEdge(expectedNodes[2], DegreeAngle.RIGHT, expectedNodes[3]),
                TileEdge(expectedNodes[3], DegreeAngle.LEFT, expectedNodes[2])
        )

        // when
        val actualGrid = Grid(width, height)

        // then
        assertThat(actualGrid.nodes).containsExactlyInAnyOrderElementsOf(expectedNodes)
        assertThat(actualGrid.edges).containsExactlyInAnyOrderElementsOf(expectedEdges)
    }

    @Test
    fun `should generate 3x2 grid`() {
        // given
        val width = 3
        val height = 2

        val expectedNodes = listOf(
                Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 0)),
                Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 0)),
                Tile(CartesianCoordinate(Dimension.X, 2), CartesianCoordinate(Dimension.Y, 0)),
                Tile(CartesianCoordinate(Dimension.X, 0), CartesianCoordinate(Dimension.Y, 1)),
                Tile(CartesianCoordinate(Dimension.X, 1), CartesianCoordinate(Dimension.Y, 1)),
                Tile(CartesianCoordinate(Dimension.X, 2), CartesianCoordinate(Dimension.Y, 1))
        )

        val expectedEdges = listOf(
                TileEdge(expectedNodes[0], DegreeAngle.RIGHT, expectedNodes[1]),
                TileEdge(expectedNodes[1], DegreeAngle.LEFT, expectedNodes[0]),

                TileEdge(expectedNodes[0], DegreeAngle.UP, expectedNodes[3]),
                TileEdge(expectedNodes[3], DegreeAngle.DOWN, expectedNodes[0]),

                TileEdge(expectedNodes[1], DegreeAngle.RIGHT, expectedNodes[2]),
                TileEdge(expectedNodes[2], DegreeAngle.LEFT, expectedNodes[1]),

                TileEdge(expectedNodes[1], DegreeAngle.UP, expectedNodes[4]),
                TileEdge(expectedNodes[4], DegreeAngle.DOWN, expectedNodes[1]),

                TileEdge(expectedNodes[2], DegreeAngle.UP, expectedNodes[5]),
                TileEdge(expectedNodes[5], DegreeAngle.DOWN, expectedNodes[2]),

                TileEdge(expectedNodes[3], DegreeAngle.RIGHT, expectedNodes[4]),
                TileEdge(expectedNodes[4], DegreeAngle.LEFT, expectedNodes[3]),

                TileEdge(expectedNodes[4], DegreeAngle.RIGHT, expectedNodes[5]),
                TileEdge(expectedNodes[5], DegreeAngle.LEFT, expectedNodes[4])
        )

        // when
        val actualGrid = Grid(width, height)

        // then
        assertThat(actualGrid.nodes).containsExactlyInAnyOrderElementsOf(expectedNodes)
        assertThat(actualGrid.edges).containsExactlyInAnyOrderElementsOf(expectedEdges)
    }

    @Test
    fun `should generate 3x4 grid`() {
        // given
        val width = 3
        val height = 4

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

        val expectedEdges = listOf(
                TileEdge(expectedNodes[0], DegreeAngle.RIGHT, expectedNodes[1]),
                TileEdge(expectedNodes[1], DegreeAngle.LEFT, expectedNodes[0]),

                TileEdge(expectedNodes[0], DegreeAngle.UP, expectedNodes[3]),
                TileEdge(expectedNodes[3], DegreeAngle.DOWN, expectedNodes[0]),

                TileEdge(expectedNodes[1], DegreeAngle.UP, expectedNodes[4]),
                TileEdge(expectedNodes[4], DegreeAngle.DOWN, expectedNodes[1]),

                TileEdge(expectedNodes[1], DegreeAngle.RIGHT, expectedNodes[2]),
                TileEdge(expectedNodes[2], DegreeAngle.LEFT, expectedNodes[1]),

                TileEdge(expectedNodes[2], DegreeAngle.UP, expectedNodes[5]),
                TileEdge(expectedNodes[5], DegreeAngle.DOWN, expectedNodes[2]),

                TileEdge(expectedNodes[3], DegreeAngle.RIGHT, expectedNodes[4]),
                TileEdge(expectedNodes[4], DegreeAngle.LEFT, expectedNodes[3]),

                TileEdge(expectedNodes[3], DegreeAngle.UP, expectedNodes[6]),
                TileEdge(expectedNodes[6], DegreeAngle.DOWN, expectedNodes[3]),

                TileEdge(expectedNodes[4], DegreeAngle.RIGHT, expectedNodes[5]),
                TileEdge(expectedNodes[5], DegreeAngle.LEFT, expectedNodes[4]),

                TileEdge(expectedNodes[4], DegreeAngle.UP, expectedNodes[7]),
                TileEdge(expectedNodes[7], DegreeAngle.DOWN, expectedNodes[4]),

                TileEdge(expectedNodes[5], DegreeAngle.UP, expectedNodes[8]),
                TileEdge(expectedNodes[8], DegreeAngle.DOWN, expectedNodes[5]),

                TileEdge(expectedNodes[6], DegreeAngle.RIGHT, expectedNodes[7]),
                TileEdge(expectedNodes[7], DegreeAngle.LEFT, expectedNodes[6]),

                TileEdge(expectedNodes[6], DegreeAngle.UP, expectedNodes[9]),
                TileEdge(expectedNodes[9], DegreeAngle.DOWN, expectedNodes[6]),

                TileEdge(expectedNodes[7], DegreeAngle.RIGHT, expectedNodes[8]),
                TileEdge(expectedNodes[8], DegreeAngle.LEFT, expectedNodes[7]),

                TileEdge(expectedNodes[7], DegreeAngle.UP, expectedNodes[10]),
                TileEdge(expectedNodes[10], DegreeAngle.DOWN, expectedNodes[7]),

                TileEdge(expectedNodes[8], DegreeAngle.UP, expectedNodes[11]),
                TileEdge(expectedNodes[11], DegreeAngle.DOWN, expectedNodes[8]),

                TileEdge(expectedNodes[9], DegreeAngle.RIGHT, expectedNodes[10]),
                TileEdge(expectedNodes[10], DegreeAngle.LEFT, expectedNodes[9]),

                TileEdge(expectedNodes[10], DegreeAngle.RIGHT, expectedNodes[11]),
                TileEdge(expectedNodes[11], DegreeAngle.LEFT, expectedNodes[10])
        )

        // when
        val actualGrid = Grid(width, height)

        // then
        assertThat(actualGrid.nodes).containsExactlyInAnyOrderElementsOf(expectedNodes)
        assertThat(actualGrid.edges).containsExactlyInAnyOrderElementsOf(expectedEdges)
    }
}