package com.snad.stringsToXml

interface MainView {
    fun showAlert(title: String, message: String)
    fun showPreview(xmlString: String)
    fun showSaveDialog(): String?
    fun registerSaveButtonListener(listener: (ids: String, translationStrings: String) -> Unit)
    fun registerPreviewButtonListener(listener: (ids: String, translationStrings: String) -> Unit)
}