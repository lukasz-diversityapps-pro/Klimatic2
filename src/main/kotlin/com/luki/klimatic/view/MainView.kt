package com.luki.klimatic.view

import com.luki.klimatic.app.Styles
import com.luki.klimatic.controller.ForecastController
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    val forecastController: ForecastController by inject()

    init {
        forecastController.listPayload("Szczecin")
    }

    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}