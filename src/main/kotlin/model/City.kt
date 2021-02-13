package model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class City : JsonModel {
    val cityNameProperty = SimpleStringProperty()
    var cityName by cityNameProperty

    val countryCodeProperty = SimpleStringProperty()
    var countryCode by countryCodeProperty

    val latitudeProperty = SimpleDoubleProperty()
    var latitude by latitudeProperty

    val longitudeProperty = SimpleDoubleProperty()
    var longitude by longitudeProperty

    val dataProperty = SimpleListProperty<Data>()
    var data: List<Data> by property(dataProperty)

    override fun updateModel(json: JsonObject) {
        with(json) {
            cityName = getString("city_name")
            countryCode = getString("country_code")
            latitude = getDouble("lat")
            longitude = getDouble("lon")
            data = getJsonArray("data").toModel()
        }
    }
}

class CityModel : ItemViewModel<City>() {
    val cityName = bind(City::cityNameProperty)
    val countryCode = bind(City::countryCodeProperty)
    val latitude = bind(City::latitudeProperty)
    val longitude = bind(City::longitudeProperty)
}