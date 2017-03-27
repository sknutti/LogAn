package com.stgconsulting.aut

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class LogAnalyzerTest: Spek({

    fun makeLogAnalyzer(): LogAnalyzer {
        return LogAnalyzer()
    }

    given("isValidLogFileName") {
        listOf(
                listOf("fileWithBadExtension.foo", false),
                listOf("fileWithBadExtension.slf", true),
                listOf("fileWithBadExtension.SLF", true)
        ).forEach({ (filename, expected) ->
            given(filename as String) {

                on("when checking for valid filename extension") {
                    val analyzer = makeLogAnalyzer()
                    val result = analyzer.isValidLogFileName(filename)

                    it("should note if the filename is valid or not") {
                        result.should.equal(expected as Boolean)
                    }
                }
            }
        })
    }
})