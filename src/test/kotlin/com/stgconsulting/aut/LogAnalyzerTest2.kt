package com.stgconsulting.aut

import io.kotlintest.specs.FeatureSpec
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue


class LogAnalyzerTest2 : FeatureSpec() {

    init {
        feature("isValidLogFileName") {
            scenario("when empty filename should throw exception") {
                val analyzer = makeLogAnalyzer()

                val exception = assertFailsWith(IllegalArgumentException::class, {
                    analyzer.isValidLogFileName("")
                })

                assertTrue { exception.message!!.contains("Filename must be provided") }
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