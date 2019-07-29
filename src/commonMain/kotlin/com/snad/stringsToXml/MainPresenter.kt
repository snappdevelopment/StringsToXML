package com.snad.stringsToXml

interface MainPresenter {
    fun onSaveButtonClicked(ids: String, translationStrings: String)
    fun onPreviewButtonClicked(ids: String, translationStrings: String)
}