package com.stgconsulting.aut

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class LogAnalyzerTest(val filename: String, val expected: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                    arrayOf("fileWithBadExtension.foo", false),
                    arrayOf("fileWithBadExtension.slf", true),
                    arrayOf("fileWithBadExtension.SLF", true))
        }

        @JvmStatic
        fun makeLogAnalyzer(): TestableLogAnalyzer {
            return TestableLogAnalyzer()
        }
    }

    @Test
    fun isValidLogFileName_MultipleExtensions_ReturnsResult() {
        val analyzer = makeLogAnalyzer()
        analyzer.fileExtensionList = listOf(".slf")
        val result = analyzer.isValidLogFileName(filename)

        assertEquals(expected, result)
    }
}