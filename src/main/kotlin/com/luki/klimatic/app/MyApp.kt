package com.luki.klimatic.app

import com.luki.klimatic.view.WeatherForecast
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(WeatherForecast::class, Styles::class) {
    override fun start(stage: Stage) {
        with(stage) {
            width = 1200.0
            height = 600.0
        }
        super.start(stage)
    }
}