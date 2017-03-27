package com.stgconsulting.aut


class LogAnalyzer {

    private var _wasLastFilenameValid: Boolean = false
    var wasLastFilenameValid: Boolean
        get() = _wasLastFilenameValid
        set(value) {
            _wasLastFilenameValid = value
        }

    fun isValidLogFileName(filename: String): Boolean {
        wasLastFilenameValid = false
        if (filename.isEmpty()) throw IllegalArgumentException("Filename must be provided")
        val result = filename.endsWith(".slf", ignoreCase = true)
        wasLastFilenameValid = result
        return result
    }
}
