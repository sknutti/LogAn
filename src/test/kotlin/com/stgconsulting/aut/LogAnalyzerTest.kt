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
        fun makeLogAnalyzer(): LogAnalyzer {
            return LogAnalyzer()
        }
    }

    @Test
    fun isValidLogFileName_MultipleExtensions_ReturnsResult() {
        val analyzer = makeLogAnalyzer()
        val result = analyzer.isValidLogFileName(filename)

        assertEquals(expected, result)
    }
}