package com.stgconsulting.aut

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doThrow
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test


class LogAnalyzerTest4 {

    companion object {
        @JvmStatic
        fun makeLogAnalyzer(logger: ILogger, webService: IWebService): LogAnalyzer2 {
            return LogAnalyzer2(logger, webService)
        }
    }

    @Test
    fun analyze_FilenameLengthIsInvalid_CallsLogger() {
        val mockLogger = mock<ILogger> { }
        val stubWebService = mock<IWebService> { }
        val analyzer = makeLogAnalyzer(mockLogger, stubWebService)
        analyzer.minNameLength = 8

        analyzer.analyze("abc.ext")

        verify(mockLogger).logError(any<String>())
    }

    @Test
    fun analyze_LoggerThrowsException_CallsWebService() {
        val mockWebService = mock<IWebService> {  }
        val stubLogger = mock<ILogger> {
            on { logError(any()) } doThrow RuntimeException("fake exception")
        }
        val analyzer = makeLogAnalyzer(stubLogger, mockWebService)
        analyzer.minNameLength = 8

        analyzer.analyze("abc.ext")

        verify(mockWebService).write(any<String>())
    }
}