package com.luki.klimatic.model

import javafx.beans.property.*
import tornadofx.*
import java.time.LocalDate
import javax.json.JsonObject

class Data : JsonModel {
    val validDateProperty = SimpleObjectProperty<LocalDate>()
    var validDate by validDateProperty

    val timestampProperty = SimpleLongProperty()
    var timestamp by timestampProperty

    val sunriseTimestampProperty = SimpleLongProperty()
    var sunriseTimestamp by sunriseTimestampProperty

    val sunsetTimestampProperty = SimpleLongProperty()
    var sunsetTimestamp by sunsetTimestampProperty

    val weatherProperty = SimpleObjectProperty<Weather>()
    var weather by weatherProperty

    val snowProperty = SimpleDoubleProperty()
    var snow by snowProperty

    val snowDepthProperty = SimpleDoubleProperty()
    var snowDepth by snowDepthProperty

    val precipitationProperty = SimpleDoubleProperty()
    var precipitation by precipitationProperty

    val probabilityOfPrecipitationProperty = SimpleIntegerProperty()
    var probabilityOfPrecipitation by probabilityOfPrecipitationProperty

    val temperatureProperty = SimpleDoubleProperty()
    var temperature by temperatureProperty

    val maxTempProperty = SimpleDoubleProperty()
    var maxTemp by maxTempProperty

    val minTempProperty = SimpleDoubleProperty()
    var minTemp by minTempProperty

    val apparentMaxTempProperty = SimpleDoubleProperty()
    var apparentMaxTemp by apparentMaxTempProperty

    val apparentMinTempProperty = SimpleDoubleProperty()
    var apparentMinTemp by apparentMinTempProperty

    val highTempProperty = SimpleDoubleProperty()
    var highTemp by highTempProperty

    val lowTempProperty = SimpleDoubleProperty()
    var lowTemp by lowTempProperty

    val pressureProperty = SimpleDoubleProperty()
    var pressure by pressureProperty

    val seaLevelPressureProperty = SimpleDoubleProperty()
    var seaLevelPressure by seaLevelPressureProperty

    val cloudsProperty = SimpleIntegerProperty()
    var clouds by cloudsProperty

    val cloudsLowProperty = SimpleIntegerProperty()
    var cloudsLow by cloudsLowProperty

    val cloudsMidProperty = SimpleIntegerProperty()
    var cloudsMid by cloudsMidProperty

    val cloudsHiProperty = SimpleIntegerProperty()
    var cloudsHi by cloudsHiProperty

    val visibilityProperty = SimpleIntegerProperty()
    var visibility by visibilityProperty

    val humidityProperty = SimpleIntegerProperty()
    var humidity by humidityProperty

    val dewPointProperty = SimpleIntegerProperty()
    var dewPoint by dewPointProperty

    val uvProperty = SimpleDoubleProperty()
    var uv by uvProperty

    val ozoneProperty = SimpleDoubleProperty()
    var ozone by ozoneProperty

    val windSpeedProperty = SimpleDoubleProperty()
    var windSpeed by windSpeedProperty

    val windGustSpeedProperty = SimpleDoubleProperty()
    var windGustSpeed by windGustSpeedProperty

    val windDirectionProperty = SimpleIntegerProperty()
    var windDirection by windDirectionProperty

    val abbreviatedWindDirectionProperty = SimpleStringProperty()
    var abbreviatedWindDirection by abbreviatedWindDirectionProperty

    val verbalWindDirectionProperty = SimpleStringProperty()
    var verbalWindDirection by verbalWindDirectionProperty

    override fun updateModel(json: JsonObject) {
        with(json){
            validDate = LocalDate.parse(getString("valid_date"))
            timestamp = getLong("ts")
            sunriseTimestamp = getLong("sunrise_ts")
            sunsetTimestamp = getLong("sunset_ts")
            weather = getJsonObject("weather").toModel()
            snow = getDouble("snow")
            snowDepth = getDouble("snow_depth")
            precipitation = getDouble("precip")
            probabilityOfPrecipitation = getInt("pop")
            temperature = getDouble("temp")
            maxTemp = getDouble("max_temp")
            minTemp = getDouble("min_temp")
            apparentMaxTemp = getDouble("app_max_temp")
            apparentMinTemp = getDouble("app_min_temp")
            highTemp = getDouble("high_temp")
            lowTemp = getDouble("low_temp")
            pressure = getDouble("pres")
            seaLevelPressure = getDouble("slp")
            clouds = getInt("clouds")
            cloudsLow = getInt("clouds_low")
            cloudsMid = getInt("clouds_mid")
            cloudsHi = getInt("clouds_hi")
            visibility = getInt("vis")
            humidity = getInt("rh")
            dewPoint = getInt("dewpt")
            uv = getDouble("uv")
            ozone = getDouble("ozone")
            windSpeed = getDouble("wind_spd")
            windGustSpeed = getDouble("wind_gust_spd")
            windDirection = getInt("wind_dir")
            abbreviatedWindDirection = getString("wind_cdir")
            verbalWindDirection = getString("wind_cdir_full")
        }
    }
}
