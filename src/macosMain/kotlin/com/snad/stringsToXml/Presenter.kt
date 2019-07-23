package com.snad.stringsToXml


class Presenter(private val view: MainView): MainPresenter{

    override fun onSaveButtonClicked(ids: String, translationStrings: String) {
        val xmlString = createXMLFromText(ids, translationStrings)
        if(xmlString.isNullOrEmpty()){
            view.showAlert("Saving failed!", "Your lists differ in length or are empty!")
        }
        else {
            saveXML(xmlString)
        }
    }

    override fun onPreviewButtonClicked(ids: String, translationStrings: String): String? {
        val xmlString = createXMLFromText(ids, translationStrings)
        if(xmlString.isNullOrEmpty()) {
            view.showAlert(
                "No preview available!",
                "XML couldn't be created. Your lists differ in length or are empty!"
            )
        }
        return xmlString
    }

    private fun createXMLFromText(ids: String, translationStrings: String): String?{
        val translationsList = createTranslationsListFromText(ids, translationStrings)
        return if (translationsList.isEmpty()) null else XMLCreator().createXMLString(translationsList)
    }

    private fun saveXML(xmlString: String){
        FileWriter().saveXMLFile(xmlString, saveXMLFileCompletionHandler)
    }

    private val saveXMLFileCompletionHandler = { result: FileWriterResult ->
        if (result == FileWriterResult.FAILURE) {
            view.showAlert("Saving failed!", "Could not save file to disk!")
        }
    }

    private fun createTranslationsListFromText(ids: String, translationStrings: String) : MutableList<Translation>{
        val idStringsList = ids.trim().split("\n")
        val translationStringsList = translationStrings.trim().split("\n")

        val translations: MutableList<Translation> = mutableListOf()

        if (idStringsList.size == translationStringsList.size) {
            for ((index, idString) in idStringsList.withIndex()) {
                val translation = Translation(idString, translationStringsList[index])
                translations.add(translation)
            }
        }

        return translations
    }

}