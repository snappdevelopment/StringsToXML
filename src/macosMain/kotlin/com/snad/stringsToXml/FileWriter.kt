package com.snad.stringsToXml

import platform.Foundation.*

actual class FileWriter {

    actual fun saveXMLFile(xmlContent: String, filepath: String, completionHandler: (result: FileWriterResult) -> Unit) {
        val xmlAsNSString = NSString.create(string = xmlContent)
        val writeResponse = xmlAsNSString.writeToURL(NSURL(fileURLWithPath = filepath), true, NSUTF8StringEncoding, null)
        val writeSuccess = if(writeResponse) FileWriterResult.SUCCESS else FileWriterResult.FAILURE

        completionHandler(writeSuccess)
    }
}