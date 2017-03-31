package com.stgconsulting.aut

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class LogAnalyzerTest3(val filename: String, val expected: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                    arrayOf("fileWithBadExtension.foo", false),
                    arrayOf("fileWithBadExtension.slf", true))
        }

        @JvmStatic
        fun makeLogAnalyzer(): TestableLogAnalyzer {
            return TestableLogAnalyzer()
        }
    }

    @Test
    fun isValidLogFileName_WhenCalled_ChangesWasLastFilenameValid() {
        val analyzer = makeLogAnalyzer()
        analyzer.fileExtensionList = listOf(".slf")

        analyzer.isValidLogFileName(filename)
        val result = analyzer.wasLastFilenameValid
        assertEquals(expected, result)
    }
}