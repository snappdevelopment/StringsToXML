//
//  ViewController.swift
//  StringsToXML
//
//  Created by Sebastian on 12.06.19.
//  Copyright © 2019 SNAD. All rights reserved.
//

import Cocoa
import StringsToXMLKt

class ViewController: NSViewController, MacView {
    
    @IBOutlet var idsTextView: NSTextView!
    @IBOutlet var stringsTextView: NSTextView!
    var presenter: Presenter!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        presenter = Presenter(view: self)
        
        idsTextView.textContainer?.containerSize = NSMakeSize(.greatestFiniteMagnitude, .greatestFiniteMagnitude)
        stringsTextView.textContainer?.containerSize = NSMakeSize(.greatestFiniteMagnitude, .greatestFiniteMagnitude)

    }

    override var representedObject: Any? {
        didSet {
        // Update the view, if already loaded.
        }
    }
    
    @IBAction func saveButtonClicked(_ sender: NSButton) {
        if let idsString = idsTextView.textStorage, let translationString = stringsTextView.textStorage {
            presenter.createXMLFromText(ids: idsString.string, translationStrings: translationString.string)
        }
        else {
            showAlert(title: "Saving failed!", message: "Could not get text from the text boxes!")
        }
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

