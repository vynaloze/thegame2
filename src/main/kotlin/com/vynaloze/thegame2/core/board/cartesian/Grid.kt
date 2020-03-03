package com.vynaloze.thegame2.core.board.cartesian


data class Grid(val width: Int, val height: Int) {
    val nodes: List<Tile> = generateNodes()
    val edges: List<TileEdge> = generateEdges()

    private fun generateNodes(): List<Tile> {
        val nodes = mutableListOf<Tile>()
        for (x in 0 until width) {
            for (y in 0 until height) {
                nodes.add(Tile(CartesianCoordinate(Dimension.X, x), CartesianCoordinate(Dimension.Y, y)))
            }
        }
        return nodes
    }

    private fun generateEdges(): List<TileEdge> {
        return nodes.flatMap{ tile -> findEdgesFor(tile) }
    }

    private fun findEdgesFor(tile :Tile): List<TileEdge> {
        val edges = mutableListOf<TileEdge>()
        val x = tile.coordinates.find { c -> c.dimension == Dimension.X }?.value ?: throw Exception() // fixme throw sth meaningful
        val y = tile.coordinates.find { c -> c.dimension == Dimension.Y }?.value ?: throw Exception() // fixme throw sth meaningful

        fun addEdge(direction: DegreeAngle, x: Int, y: Int) {
            val neighbour = nodes.find { n ->
                n.coordinates == listOf(CartesianCoordinate(Dimension.X, x), CartesianCoordinate(Dimension.Y, y))
            }
            if (neighbour != null) {
                edges.add(TileEdge(tile, direction, neighbour))
            }
        }

        if (x > 0) {
            addEdge(DegreeAngle.LEFT, x - 1, y)
        }
        if (x < width - 1) {
            addEdge(DegreeAngle.RIGHT, x + 1, y)
        }
        if (y > 0) {
            addEdge(DegreeAngle.DOWN, x, y - 1)
        }
        if (y < height - 1) {
            addEdge(DegreeAngle.UP, x, y + 1)
        }

        return edges
    }
}
