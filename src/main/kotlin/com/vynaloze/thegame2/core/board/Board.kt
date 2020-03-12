package com.vynaloze.thegame2.core.board


interface Board {
    val nodes: List<Node>
    val edges: Map<Node, List<Edge>>
}