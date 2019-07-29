package com.snad.stringsToXml

import javafx.application.Application
import javafx.stage.Stage

class JVMMain: Application() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            launch(JVMMain::class.java)
        }
    }

    override fun start(primaryStage: Stage) {
        val view: MainView = JVMView(primaryStage)
        val presenter: MainPresenter = Presenter(view)
    }
}
