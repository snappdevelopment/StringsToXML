//
//  AppDelegate.swift
//  StringsToXML
//
//  Created by Sebastian on 12.06.19.
//  Copyright © 2019 SNAD. All rights reserved.
//

import Cocoa

@NSApplicationMain
class AppDelegate: NSObject, NSApplicationDelegate {

    lazy var windows = NSWindow()
    
    func applicationShouldHandleReopen(_ sender: NSApplication, hasVisibleWindows flag: Bool) -> Bool {
        if !flag {
            for window in sender.windows {
                window.makeKeyAndOrderFront(self)
            }
        }
        
        return true
    }

    func applicationDidFinishLaunching(_ aNotification: Notification) {
        // Insert code here to initialize your application
    }

    func applicationWillTerminate(_ aNotification: Notification) {
        // Insert code here to tear down your application
    }


}

