package com.example.demo.view

import com.example.demo.view.crud.CreateFragment
import com.example.demo.view.crud.ReadFragment
import javafx.scene.control.TabPane
import tornadofx.*

class Header : View() {
    override val root = tabpane {
        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
        tab<CreateFragment>()
        tab<ReadFragment>()
        tab("UPDATE")
        tab("DELETE")
    }
}