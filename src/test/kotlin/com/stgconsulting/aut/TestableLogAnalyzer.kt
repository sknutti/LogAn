package com.stgconsulting.aut

class TestableLogAnalyzer: LogAnalyzer() {
    var fileExtensionList: Collection<String> = emptyList()

    override fun getValidFileExtensions(): Collection<String> {
        return fileExtensionList
    }
}
