package com.snad.stringsToXml

import java.io.File

actual class FileWriter {

    actual fun saveXMLFile(xmlContent: String, filepath: String, completionHandler: (result: FileWriterResult) -> Unit) {
        File(filepath).writeText(xmlContent)
    }
}