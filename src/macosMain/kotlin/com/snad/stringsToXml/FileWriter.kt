package com.snad.stringsToXml

import platform.AppKit.*
import platform.Foundation.*

class FileWriter {

    fun saveXMLFile(xmlContent: String, completionHandler: (result: FileWriterResult) -> Unit) {
        var writeSuccess = FileWriterResult.CANCELLED

        var saveDialog = NSSavePanel()
        saveDialog.title = "Save as..."
        saveDialog.extensionHidden = false
        saveDialog.nameFieldStringValue = "strings.xml"
        saveDialog.beginWithCompletionHandler { result ->
            if (result == NSFileHandlingPanelOKButton.toLong()) {
                val filepathAndName = saveDialog.filename()
                val xmlAsNSString = NSString.create(string = xmlContent)
                val writeResponse = xmlAsNSString.writeToURL(NSURL(fileURLWithPath = filepathAndName), true)
                writeSuccess = if(writeResponse) FileWriterResult.SUCCESS else FileWriterResult.FAILURE
            }
            saveDialog.close()
            completionHandler(writeSuccess)
        }
    }
}

enum class FileWriterResult{
    SUCCESS, FAILURE, CANCELLED
}