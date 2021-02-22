package com.luki.klimatic.controller

import com.luki.klimatic.model.CityModel
import com.luki.klimatic.model.ForecastPayload
import com.luki.klimatic.util.appid
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.Controller
import tornadofx.Rest
import tornadofx.toModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.time.LocalDate
import java.time.Month

class ForecastController : Controller() {
    val selectedCity: CityModel by inject()

    var allWeather = FXCollections.emptyObservableList<ForecastPayload>()

    val api: Rest by inject()

    init {
        api.baseURI = "https://api.weatherbit.io/v2.0/forecast/daily/"
    }

    fun listPayload(cityName: String = selectedCity.cityName.value): ObservableList<ForecastPayload> = api.get(
        "?city=${
            URLEncoder.encode(
                cityName,
                StandardCharsets.UTF_8.toString()
            )
        }&country=PL&lang=pl&key=$appid")
        .list().toModel()

    fun getMonth(): String {
        return when(LocalDate.now().month) {
            Month.FEBRUARY -> "luty"
            Month.MARCH -> "marzec"
            Month.APRIL -> "kwiecien"
            else -> "kwiecien"
        }
    }

    fun getRandom(end: Int): String {
        return addZero((1..end).shuffled().first().toString())
    }

    private fun addZero(text: String): String {
        return if (text.length == 2) text else "0$text"
    }
}