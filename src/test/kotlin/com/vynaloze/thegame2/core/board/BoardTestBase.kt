package com.vynaloze.thegame2.core.board

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory


abstract class BoardTestBase {
    data class TestCase(
            val description: String,
            val actualBoard: Board,
            val expectedNodes: List<Node>,
            val expectedEdges: List<Edge>
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
        Assertions.assertThat(testCase.actualBoard.nodes).containsExactlyInAnyOrderElementsOf(testCase.expectedNodes)
        Assertions.assertThat(testCase.actualBoard.edges).containsExactlyInAnyOrderElementsOf(testCase.expectedEdges)
    }
}