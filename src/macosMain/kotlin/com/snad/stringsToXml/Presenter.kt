package com.snad.stringsToXml


class Presenter(private val view: MacView) {

    fun createXMLFromText(ids: String, translationStrings: String){
        val translationsList = createTranslationsListFromText(ids, translationStrings)
        val xmlString = XMLCreator().createXMLString(translationsList)
        FileWriter().saveXMLFile(xmlString, saveXMLFileCompletionHandler)
    }

    private val saveXMLFileCompletionHandler = { result: FileWriterResult ->
        if (result == FileWriterResult.FAILURE) {
            view.showAlert("Saving failed!", "Could not save file to disk!")
        }
    }

    fun createXMLFromCSV(){

    }

    private fun createTranslationsListFromText(ids: String, translationStrings: String) : MutableList<Translation> {
        val idsStringList = ids.split("\n")
        val translationStringsList = translationStrings.split("\n")

        val translations: MutableList<Translation> = mutableListOf()

        for ((index, translatedString) in translationStringsList.withIndex()) {
            val translation = Translation(idsStringList[index], translatedString)
            translations.add(translation)
        }

        return translations
    }

}