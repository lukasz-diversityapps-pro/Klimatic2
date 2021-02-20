package com.luki.klimatic.app

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Color.BLACK
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val mainLabels by cssclass()
        val heading by cssclass()
        val contentWrapper by cssclass()
    }

    init {
        mainLabels {
            fontSize = 20.px
            fill = BLACK
            fontFamily = "Kanit"
        }

        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            fontFamily = "Kanit"
        }

        contentWrapper {
            minWidth = 980.px
            maxWidth = minWidth
            alignment = Pos.CENTER
        }
    }
}