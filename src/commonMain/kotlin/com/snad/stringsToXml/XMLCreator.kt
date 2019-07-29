package com.snad.stringsToXml

class XMLCreator {

    fun createXMLString(translations: MutableList<Translation>): String {
        val header = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<resources>\n"
        val footer = "</resources>"

        var xmlString = ""

        for(translation in translations) {
            xmlString = xmlString.plus("  <string name=\"${translation.id}\">${translation.translatedString}</string>\n")
        }

        return header.plus(xmlString).plus(footer)
    }

}