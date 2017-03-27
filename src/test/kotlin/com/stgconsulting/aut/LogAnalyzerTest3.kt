package com.stgconsulting.aut

import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.FeatureSpec
import org.junit.Assert.assertEquals


class LogAnalyzerTest3 : FeatureSpec() {

    init {
        feature("isValidLogFileName") {
            scenario("when called should update wasLastFilenameValid property") {
                val data = table(
                        headers("filename", "expected"),
                        row("fileWithBadExtension.foo", false),
                        row("fileWithBadExtension.slf", true)
                )

                forAll(data) { filename, expected ->
                    val analyzer = makeLogAnalyzer()

                    analyzer.isValidLogFileName(filename)
                    val result = analyzer.wasLastFilenameValid
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