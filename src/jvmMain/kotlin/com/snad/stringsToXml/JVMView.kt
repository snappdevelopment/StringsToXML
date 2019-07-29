package com.snad.stringsToXml

import javafx.scene.control.Alert
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox
import javafx.scene.layout.HBox
import javafx.stage.FileChooser
import javafx.stage.Modality


class JVMView(primaryStage: Stage): MainView {

    private var idsTextArea: TextArea = TextArea()
    private var stringsTextArea: TextArea = TextArea()
    private var saveButton: Button = Button()
    private var previewButton: Button = Button()

    init {
        loadUI(primaryStage)
    }

    private fun loadUI(primaryStage: Stage) {

        val idsAndStringsHBox = HBox(5.0)
        idsAndStringsHBox.padding = Insets(1.0)

        val idsLabel = Label("IDs:")
        idsLabel.padding = Insets(2.0)

        idsTextArea.minWidth = 300.0
        idsTextArea.minHeight = 500.0
        idsTextArea.padding = Insets(2.0)
        idsTextArea.promptText = "Paste the names/IDs of your strings. One name per line."

        val idsVBox = VBox(5.0)
        idsVBox.children.addAll(idsLabel, idsTextArea)

        val stringsLabel = Label("Strings:")
        stringsLabel.padding = Insets(2.0)

        stringsTextArea.minWidth = 300.0
        stringsTextArea.minHeight = 500.0
        stringsTextArea.padding = Insets(2.0)
        stringsTextArea.promptText = "Paste your strings. One string per line."

        saveButton.text = "Save"
        previewButton.text = "Preview"

        val buttonsHBox = HBox(5.0)
        buttonsHBox.children.addAll(previewButton, saveButton)
        buttonsHBox.alignment = Pos.BOTTOM_RIGHT

        val stringsVBox = VBox(5.0)
        stringsVBox.children.addAll(stringsLabel, stringsTextArea, buttonsHBox)

        idsAndStringsHBox.children.addAll(idsVBox, stringsVBox)

        val containerBox = VBox(5.0)
        containerBox.children.addAll(idsAndStringsHBox)
        containerBox.padding = Insets(10.0)

        primaryStage.title = "StringsToXML"
        primaryStage.scene = Scene(containerBox, 610.0, 580.0)
        primaryStage.minHeight = 600.0
        primaryStage.minWidth = 700.0
        primaryStage.maxHeight = 600.0
        primaryStage.maxWidth = 1100.0
        primaryStage.show()
    }

    override fun showPreview(xmlString: String) {
        val previewStage = Stage()

        val textArea = TextArea()
        textArea.minWidth = 300.0
        textArea.minHeight = 500.0
        textArea.padding = Insets(2.0)
        textArea.text = xmlString

        previewStage.title = "Preview"
        previewStage.scene = Scene(textArea, 610.0, 580.0)
        previewStage.minHeight = 600.0
        previewStage.minWidth = 700.0
        previewStage.maxHeight = 600.0
        previewStage.maxWidth = 1100.0

        previewStage.initModality(Modality.APPLICATION_MODAL)
        previewStage.showAndWait()
    }

    override fun showSaveDialog(): String? {
        val chooser = FileChooser()
        chooser.title = "Save as"
        chooser.initialFileName = "strings.xml"
        val file = chooser.showSaveDialog(Stage())

        return file?.absolutePath
    }

    override fun registerSaveButtonListener(listener: (ids: String, translationStrings: String) -> Unit) {
        saveButton.setOnAction{
            listener(idsTextArea.text, stringsTextArea.text)
        }
    }

    override fun registerPreviewButtonListener(listener: (ids: String, translationStrings: String) -> Unit) {
        previewButton.setOnAction {
            listener(idsTextArea.text, stringsTextArea.text)
        }
    }

    override fun showAlert(title: String, message: String) {
        val alert = Alert(Alert.AlertType.ERROR)
        alert.title = "Error"
        alert.headerText = title
        alert.contentText = message

        alert.showAndWait()
    }
}