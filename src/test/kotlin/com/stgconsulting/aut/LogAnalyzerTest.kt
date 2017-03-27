package com.stgconsulting.aut

import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.FeatureSpec
import org.junit.Assert.assertEquals


class LogAnalyzerTest : FeatureSpec() {

    init {
        feature("isValidLogFileName") {
            scenario("when multiple extensions should return correct result") {
                val data = table(
                        headers("filename", "expected"),
                        row("fileWithBadExtension.foo", false),
                        row("fileWithBadExtension.slf", true),
                        row("fileWithBadExtension.SLF", true)
                )

                forAll(data) { filename, expected ->
                    val analyzer = makeLogAnalyzer()
                    val result = analyzer.isValidLogFileName(filename)

                    assertEquals(expected, result)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun makeLogAnalyzer(): LogAnalyzer {
            return LogAnalyzer()
        }
    }
}