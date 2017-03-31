package com.stgconsulting.aut


abstract class LogAnalyzer {

    private var _wasLastFilenameValid: Boolean = false
    var wasLastFilenameValid: Boolean
        get() = _wasLastFilenameValid
        set(value) {
            _wasLastFilenameValid = value
        }

    fun isValidLogFileName(filename: String): Boolean {
        wasLastFilenameValid = false

        if (filename.isEmpty()) throw IllegalArgumentException("Filename must be provided")
        val fileExtensionList = getValidFileExtensions()
        val result = fileExtensionList.any { ext -> filename.endsWith(ext, ignoreCase = true) }

        wasLastFilenameValid = result
        return result
    }

    open fun getValidFileExtensions(): Collection<String> {
        val fileApiManager: ApiManager = FileApiManager()
        return fileApiManager.getFileExtensions()
    }
}
