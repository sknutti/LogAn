package com.stgconsulting.aut

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertFailsWith


class LogAnalyzerTest2: Spek ({

    fun makeLogAnalyzer(): LogAnalyzer {
        return LogAnalyzer()
    }

    given("isValidLogFileName") {
        val analyzer = makeLogAnalyzer()

        on("empty filename") {
            val exception = assertFailsWith(IllegalArgumentException::class, {
                analyzer.isValidLogFileName("")
            })

            it("should throw an exception") {
                exception.message!!.should.contain("Filename must be provided")
            }
        }
    }

})