package com.luki.klimatic.controller

import com.luki.klimatic.model.CityModel
import com.luki.klimatic.model.ForecastPayload
import com.luki.klimatic.model.Weather
import com.luki.klimatic.util.appid
import javafx.collections.FXCollections
import tornadofx.Controller
import tornadofx.Rest
import tornadofx.toModel
import java.time.LocalDate

class ForecastController: Controller() {
    val selectedCity: CityModel by inject()

    var allWeather = FXCollections.emptyObservableList<Weather>()

    val api: Rest by inject()
    init {
        api.baseURI = "https://api.weatherbit.io/v2.0/forecast/daily/"
    }

    fun listPayload(cityName: String = selectedCity.cityName.value): List<ForecastPayload> {
        val forecast = api.get("?city=$cityName&country=PL&lang=pl&key=$appid")
            .list().toModel<ForecastPayload>()

        forecast[0].data.forEach {
            println("${it.validDate} " +
                    "${it.temperature} min: ${it.minTemp} max: ${it.maxTemp} " +
                    "ozone: ${it.ozone} " +
                    "opady: ${it.precipitation} " +
                    "lat:${forecast[0].latitude} lon:${forecast[0].longitude}" )
        }

        return forecast
    }
}