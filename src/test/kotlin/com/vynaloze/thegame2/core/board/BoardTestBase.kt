package com.vynaloze.thegame2.core.board

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory


abstract class BoardTestBase {
    data class TestCase(
            val description: String,
            val actualBoard: Board,
            val expectedNodes: List<Node>,
            val expectedEdges: Map<Node, List<Edge>>
    )

    @TestFactory
    fun shouldGenerateBoard() = generateTestCases()
            .map { tc ->
                DynamicTest.dynamicTest("should generate board: ${tc.description}") {
                    validateTestCase(tc)
                }
            }


    protected abstract fun generateTestCases(): List<TestCase>


    private fun validateTestCase(testCase: TestCase) {
        assertThat(testCase.actualBoard.nodes).containsExactlyInAnyOrderElementsOf(testCase.expectedNodes)
        assertThat(testCase.actualBoard.edges).containsOnlyKeys(testCase.expectedEdges.keys)
        assertThat(testCase.actualBoard.edges).allSatisfy { node, edges -> assertThat(edges).containsExactlyInAnyOrderElementsOf(testCase.expectedEdges[node]) }
    }
}