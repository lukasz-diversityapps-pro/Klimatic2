package com.luki.klimatic.view

import com.luki.klimatic.app.Styles
import com.luki.klimatic.controller.ForecastController
import com.luki.klimatic.model.Data
import com.luki.klimatic.model.ForecastPayload
import com.sun.jndi.toolkit.url.Uri
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.beans.binding.Bindings
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.layout.BackgroundSize
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import tornadofx.*
import tornadofx.WizardStyles.Companion.graphic
import java.io.File
import java.math.RoundingMode
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
    var forecastView: DataGrid<Data> by singleAssign()
    var dividerHB: HBox by singleAssign()

    init {
//        forecastController.listPayload("Szczecin")
    }

    override val root = borderpane {
        style {
            backgroundImage += this::class.java.getResource("/backgrounds/" + forecastController.getMonth() + "_" + forecastController.getRandom(12) + ".jpg").toURI()
            backgroundSize += BackgroundSize(1.0, 1.0, true, true, false, true)
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

                dividerHB = hbox()
                forecastView = datagrid()
            }
        }
    }

    private fun VBox.currentWeatherView() = vbox {
        form {
            paddingAll = 40.0
            fieldset {
                field("", Orientation.VERTICAL) {
                    textfield(forecastController.selectedCity.cityName) {
                        validator {
                            if (it.isNullOrBlank()) error("Wprowadź miasto")
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
                                            paddingAll = 20.0
                                            hbox {
                                                cityLabel.text = forecastPayload.cityName + ", " +
                                                        forecastPayload.data[0].validDate.format(
                                                            DateTimeFormatter.ofPattern(
                                                                "d MMMM"
                                                            )
                                                        )

                                                cityLabel.apply {
                                                    addClass(Styles.mainLabels)
                                                }

                                                todayIcon.graphic = imageview(
                                                    "/icons/${forecastPayload.data[0].weather.icon}.png",
                                                    lazyload = true
                                                ) {
                                                    fitHeight = 50.0
                                                    fitWidth = 50.0
                                                }
                                            }
                                            todayTemp.text = "temperatura: ${forecastPayload.data[0].temperature} °C "
                                            todayPressure.text =
                                                "ciśnienie: ${forecastPayload.data[0].pressure.roundToInt()} mbar"
                                            todayPrecipitation.text = "opady: ${
                                                forecastPayload.data[0].precipitation.toBigDecimal()
                                                    .setScale(1, RoundingMode.UP).toDouble()
                                            } mm"
                                            todayTemp.apply {
                                                addClass(Styles.mainLabels)
                                            }
                                            todayPressure.apply {
                                                addClass(Styles.mainLabels)
                                            }
                                            todayPrecipitation.apply {
                                                addClass(Styles.mainLabels)
                                            }

                                            dividerHB.style {
                                                borderColor += box(
                                                    Color.TRANSPARENT,
                                                    Color.TRANSPARENT,
                                                    Color.BLACK,
                                                    Color.TRANSPARENT
                                                )
                                            }

                                            forecastView.items = forecastPayload.data.subList(0, 7).observable()
                                            forecastView.apply {
                                                cellWidth = 120.0
                                                cellHeight = 200.0
                                                cellFormat {
                                                    style {
                                                        backgroundColor += c(1.0, 1.0, 1.0, 0.5)
                                                        borderRadius += box(10.px)

                                                    }
                                                }
                                                cellCache {
                                                    stackpane {
                                                        vbox(alignment = Pos.TOP_CENTER) {
                                                            label(it.validDate.format(DateTimeFormatter.ofPattern("EEEE")))
                                                            label {
                                                                graphic =
                                                                    imageview("/icons/${it.weather.icon}.png").apply {
                                                                        fitHeight = 50.0
                                                                        fitWidth = 50.0
                                                                    }
                                                            }
                                                            paddingBottom = 20.0
                                                        }

                                                        vbox(alignment = Pos.CENTER) {
                                                            paddingTop = 80.0
                                                            label {
                                                                this.textProperty().bind(
                                                                    Bindings.concat(
                                                                        it.minTempProperty.value.toInt(),
                                                                        " °C"
                                                                    )
                                                                )
                                                            }.apply {
                                                                graphic =
                                                                    FontAwesomeIconView(FontAwesomeIcon.LONG_ARROW_DOWN)
                                                            }
                                                            label {
                                                                this.textProperty().bind(
                                                                    Bindings.concat(
                                                                        it.maxTempProperty.value.toInt(),
                                                                        " °C"
                                                                    )
                                                                )
                                                            }.apply {
                                                                graphic =
                                                                    FontAwesomeIconView(FontAwesomeIcon.LONG_ARROW_UP)
                                                            }
                                                            label {
                                                                this.textProperty().bind(
                                                                    Bindings.concat(
                                                                        it.precipitationProperty.value.toBigDecimal()
                                                                            .setScale(1, RoundingMode.UP).toDouble(),
                                                                        " mm"
                                                                    )
                                                                )
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
                    }.style {
                        backgroundColor += Color.TRANSPARENT
                        borderColor += box(Color.TRANSPARENT, Color.TRANSPARENT, Color.BLACK, Color.TRANSPARENT)
                        padding = box(0.px, 0.px, 0.px, 0.px)
                        fontSize = 40.px
                        fontFamily = "Kanit"
                        opacity = 1.0
                    }
                }
            }
        }
    }
}