package com.luki.klimatic.model

import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class ForecastPayload: JsonModel {
    val cityNameProperty = SimpleStringProperty()
    var cityName by cityNameProperty

    val countryCodeProperty = SimpleStringProperty()
    var countryCode by countryCodeProperty

    val latitudeProperty = SimpleStringProperty()
    var latitude by latitudeProperty

    val longitudeProperty = SimpleStringProperty()
    var longitude by longitudeProperty

    val dataProperty = SimpleListProperty<Data>()
    var data: List<Data> by property(dataProperty)

    override fun updateModel(json: JsonObject) {
        with(json) {
            cityName = getString("city_name")
            countryCode = getString("country_code")
            latitude = getString("lat")
            longitude = getString("lon")
            data = getJsonArray("data").toModel()
        }
    }
}