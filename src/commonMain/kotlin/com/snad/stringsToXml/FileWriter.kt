package com.snad.stringsToXml

expect class FileWriter() {
    fun saveXMLFile(xmlContent: String, filepath: String, completionHandler: (result: FileWriterResult) -> Unit)
}

enum class FileWriterResult{
    SUCCESS, FAILURE, CANCELLED
}