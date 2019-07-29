//
//  ViewController.swift
//  StringsToXML
//
//  Created by Sebastian on 12.06.19.
//  Copyright © 2019 SNAD. All rights reserved.
//

import Cocoa
import StringsToXMLKt

class ViewController: NSViewController, MainView {
    
    @IBOutlet var idsTextView: NSTextView!
    @IBOutlet var stringsTextView: NSTextView!
    var presenter: MainPresenter!
    var saveButtonListener: ((String, String) -> Void)?
    var previewButtonListener: ((String, String) -> Void)?
    var previewString: String? = nil
    
    override func viewDidLoad() {
        super.viewDidLoad()

        presenter = Presenter(view: self)
        
        idsTextView.textContainer?.containerSize = NSMakeSize(.greatestFiniteMagnitude, .greatestFiniteMagnitude)
        stringsTextView.textContainer?.containerSize = NSMakeSize(.greatestFiniteMagnitude, .greatestFiniteMagnitude)

    }
    
    @IBAction func saveButtonClicked(_ sender: NSButton) {
        saveButtonListener?(idsTextView.string, stringsTextView.string)
    }
    
    @IBAction func previewButtonClicked(_ sender: NSButton) {
        previewButtonListener?(idsTextView.string, stringsTextView.string)
    }
    
    override func prepare(for segue: NSStoryboardSegue, sender: Any?) {
        let destinationVC = segue.destinationController as! PreviewViewController
        destinationVC.xmlString = previewString
    }
    
    func showPreview(xmlString: String) {
        previewString = xmlString
        performSegue(withIdentifier: "previewSegue", sender: nil)
    }
    
    func registerSaveButtonListener(listener: @escaping (String, String) -> Void) {
        saveButtonListener = listener
    }
    
    func registerPreviewButtonListener(listener: @escaping (String, String) -> Void) {
        previewButtonListener = listener
    }
    
    func showSaveDialog() -> String? {
        var filepath: String? = nil
        let saveDialog = NSSavePanel()
        saveDialog.title = "Save as..."
        saveDialog.isExtensionHidden = false
        saveDialog.nameFieldStringValue = "strings.xml"
        let result = saveDialog.runModal()
        if (result == .OK) {
            filepath = saveDialog.url?.path
        }
        saveDialog.close()
 
        return filepath
    }
    
    func showAlert(title: String, message: String) {
        let alert = NSAlert()
        alert.messageText = title
        alert.informativeText = message
        alert.alertStyle = NSAlert.Style.warning
        alert.addButton(withTitle: "OK")
        alert.runModal()
    }
}

