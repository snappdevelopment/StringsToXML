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
    
    override func viewDidLoad() {
        super.viewDidLoad()

        presenter = Presenter(view: self)
        
        idsTextView.textContainer?.containerSize = NSMakeSize(.greatestFiniteMagnitude, .greatestFiniteMagnitude)
        stringsTextView.textContainer?.containerSize = NSMakeSize(.greatestFiniteMagnitude, .greatestFiniteMagnitude)

    }
    
    @IBAction func saveButtonClicked(_ sender: NSButton) {
        presenter.onSaveButtonClicked(ids: idsTextView.string, translationStrings: stringsTextView.string)
    }
    
    override func prepare(for segue: NSStoryboardSegue, sender: Any?) {
        let xmlString = presenter.onPreviewButtonClicked(ids: idsTextView.string, translationStrings: stringsTextView.string)
        let destinationVC = segue.destinationController as! PreviewViewController
        destinationVC.xmlString = xmlString
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

