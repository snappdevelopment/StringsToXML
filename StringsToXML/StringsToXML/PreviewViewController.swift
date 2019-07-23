//
//  PreviewViewController.swift
//  StringsToXML
//
//  Created by Sebastian on 27.06.19.
//  Copyright © 2019 SNAD. All rights reserved.
//

import Cocoa
import StringsToXMLKt

class PreviewViewController: NSViewController, NSWindowDelegate {

    var xmlString: String?
    @IBOutlet var previewTextView: NSTextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        previewTextView.string = xmlString ?? ""
    }
    
    override func viewWillAppear() {
        self.view.window?.delegate = self
        self.view.window?.minSize = NSSize(width: 570, height: 700)
    }
    
}
