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
    

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }
    
    override func viewDidAppear() {
        print("viewDidAppear")
//        let saveDialog = NSSavePanel()
//        saveDialog.title = "Save as..."
//        saveDialog.isExtensionHidden = false
//        saveDialog.nameFieldStringValue = "strings.xml"
//        //saveDialog.runModal()
//        saveDialog.begin { result in
//            let directory = saveDialog.directoryURL
//            let filename = saveDialog.nameFieldStringValue
//            print(directory)
//            print(filename)
//            if (result == .OK) {
//                do {
//                    //try "hello".write(to: URL(string: "\(directory!)\(filename)")!, atomically: true, encoding: String.Encoding.utf8)
//                    //let success = FileManager().createFile(atPath: "\(directory!)\(filename)", contents: "hello".data(using: .utf8), attributes: nil)
//                    try "hello".data(using: .utf8)?.write(to: URL(string: "\(directory!)\(filename)")!)
//
//                    print("written")
//                } catch {
//
//                    print("write failed")
//                }
//            }
//        }
        let presenter = Presenter(view: self)
        presenter.createXMLFromText(ids: "id1\nid2", translationStrings: "translation1\ntranslation2")
        
    }

    override var representedObject: Any? {
        didSet {
        // Update the view, if already loaded.
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

