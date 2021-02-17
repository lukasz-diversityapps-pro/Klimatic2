package com.luki.klimatic.view

import com.luki.klimatic.app.Styles
import com.luki.klimatic.controller.ForecastController
import com.luki.klimatic.model.ForecastPayload
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.layout.VBox
import tornadofx.*
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

class WeatherForecast : View("Klimatic") {

    val forecastController: ForecastController by inject()
    var forecastPayload = ForecastPayload()

    var cityLabel: Label by singleAssign()
    var todayTemp: Label by singleAssign()
    var todayPressure: Label by singleAssign()
    var todayPrecipitation: Label by singleAssign()
    var todayIcon: Label by singleAssign()

    init {
        forecastController.listPayload("Szczecin")
    }

    override val root = borderpane {
        style {
            backgroundColor += c("#666699")
        }

        center = vbox {
            addClass(Styles.contentWrapper)
            currentWeatherView()
            vbox(alignment = Pos.CENTER) {
                cityLabel = label()
                todayIcon = label()
                todayTemp = label()
                todayPressure = label()
                todayPrecipitation = label()
            }
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
                                forecastController.selectedCity.commit {
                                    runAsync {
                                        forecastController.allWeather =
                                            forecastController.listPayload(forecastController.selectedCity.cityName.value)
                                    } ui {
                                        forecastPayload = forecastController.allWeather[0]
                                        vbox {
                                            cityLabel.text = forecastPayload.cityName + "," +
                                                    " " + forecastPayload.data[0].validDate.format(DateTimeFormatter.ofPattern("d MMMM"))

                                            cityLabel.apply {
                                                addClass(Styles.mainLabels)
                                            }

                                            todayIcon.graphic = imageview("/icons/${forecastPayload.data[0].weather.icon}.png", lazyload = true) {
                                                fitHeight = 100.0
                                                fitWidth = 100.0
                                            }
                                            paddingBottom = 10.0

                                            todayTemp.text = "temperatura: ${forecastPayload.data[0].temperature} °C "
                                            todayPressure.text = "ciśnienie: ${forecastPayload.data[0].pressure.roundToInt()} mbar"
                                            todayPrecipitation.text = "opady: ${forecastPayload.data[0].precipitation} mm"
                                            todayTemp.apply {
                                                addClass(Styles.mainLabels)
                                            }
                                            todayPressure.apply {
                                                addClass(Styles.mainLabels)
                                            }
                                            todayPrecipitation.apply {
                                                addClass(Styles.mainLabels)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}