package com.stgconsulting.aut


class LogAnalyzer2(private val logger: ILogger, private val service: IWebService) {

    private var _wasLastFilenameValid: Boolean = false

    var minNameLength: Int = 0
        get
        set

    var wasLastFilenameValid: Boolean
        get() = _wasLastFilenameValid
        set(value) {
            _wasLastFilenameValid = value
        }

    fun analyze(filename: String) {
        if (filename.length < minNameLength) {
            try {
                logger.logError("Filename too short: $filename")
            } catch (e: Exception) {
                service.write("Error from logger: ${e.message}")
            }
        }
    }

    fun isValidLogFileName(filename: String): Boolean {
        wasLastFilenameValid = false

        if (filename.isEmpty()) throw IllegalArgumentException("Filename must be provided")
        val fileExtensionList = getValidFileExtensions()
        val result = fileExtensionList.any { ext -> filename.endsWith(ext, ignoreCase = true) }

        wasLastFilenameValid = result
        return result
    }

    fun getValidFileExtensions(): Collection<String> {
        val fileApiManager: ApiManager = FileApiManager()
        return fileApiManager.getFileExtensions()
    }
}
