package com.luki.klimatic.view

import com.luki.klimatic.app.Styles
import com.luki.klimatic.controller.ForecastController
import com.luki.klimatic.model.ForecastPayload
import javafx.geometry.Orientation
import javafx.scene.input.KeyCode
import javafx.scene.layout.VBox
import tornadofx.*

class WeatherForecast : View("Klimatic") {

    val forecastController: ForecastController by inject()
    var forecastPayload = ForecastPayload()

    init {
        forecastController.listPayload("Szczecin")
    }

    override val root = borderpane {
        style {
            backgroundColor += c("#666699")
        }

        center = vbox {
             currentWeatherView()
        }
    }

    private fun VBox.currentWeatherView() = vbox {
        form {
            paddingAll = 20.0
            fieldset {
                field("City", Orientation.VERTICAL) {
                    textfield(forecastController.selectedCity.cityName) {
                        validator {
                            if (it.isNullOrBlank()) error("City cannot be blank")
                            else null
                        }
                        setOnKeyPressed {
                            if (it.code == KeyCode.ENTER) {
                                runAsync {
                                    forecastController.allWeather = forecastController.listPayload(forecastController.selectedCity.cityName.value)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}