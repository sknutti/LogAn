package com.stgconsulting.aut


class FileApiManager : ApiManager {
    override fun getFileExtensions(): Collection<String> {
        // here we would actually read the file from the filesystem and pull out the list if extensions
        return listOf(".slf")
    }
}


