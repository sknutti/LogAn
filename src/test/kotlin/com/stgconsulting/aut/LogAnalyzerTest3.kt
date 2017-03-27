package com.stgconsulting.aut

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class LogAnalyzerTest3: Spek({

    fun makeLogAnalyzer(): LogAnalyzer {
        return LogAnalyzer()
    }

    given("isValidLogFileName") {
        listOf(
                listOf("fileWithBadExtension.foo", false),
                listOf("fileWithBadExtension.slf", true)
        ).forEach({ (filename, expected) ->
            on("when called with $filename") {
                val analyzer = makeLogAnalyzer()
                analyzer.isValidLogFileName(filename as String)
                val result = analyzer.wasLastFilenameValid

                it("should change wasLastFilenameValid to $expected") {
                    result.should.equal(expected as Boolean)
                }
            }
        })
    }
})