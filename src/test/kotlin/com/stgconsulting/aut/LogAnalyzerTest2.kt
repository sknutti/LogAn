package com.stgconsulting.aut

import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue


class LogAnalyzerTest2 {

    companion object {
        @JvmStatic
        fun makeLogAnalyzer(): LogAnalyzer {
            return LogAnalyzer()
        }
    }

    @Test
    fun isValidLogFileName_EmptyFilename_ThrowsException() {
        val analyzer = makeLogAnalyzer()

        val exception = assertFailsWith(IllegalArgumentException::class, {
            analyzer.isValidLogFileName("")
        })

        assertTrue { exception.message!!.contains("Filename must be provided") }
    }

}