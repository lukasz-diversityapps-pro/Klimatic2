package model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate
import javax.json.JsonObject

class Data : JsonModel {
    val validDateProperty = SimpleObjectProperty<LocalDate>()
    var validDate by validDateProperty

    val timestampProperty = SimpleIntegerProperty()
    var timestamp by timestampProperty

    val sunriseTimestampProperty = SimpleIntegerProperty()
    var sunriseTimestamp by sunriseTimestampProperty

    val sunsetTimestampProperty = SimpleIntegerProperty()
    var sunsetTimestamp by sunsetTimestampProperty

    val weatherProperty = SimpleObjectProperty<Weather>()
    var weather by weatherProperty

    val snowProperty = SimpleDoubleProperty()
    var snow by snowProperty

    val snowDepthProperty = SimpleIntegerProperty()
    var snowDepth by snowDepthProperty

    val precipitationProperty = SimpleDoubleProperty()
    var precipitation by precipitationProperty

    val probabilityOfPrecipitationProperty = SimpleIntegerProperty()
    var probabilityOfPrecipitation by probabilityOfPrecipitationProperty

    val temperatureProperty = SimpleIntegerProperty()
    var temperature by temperatureProperty

    val maxTempProperty = SimpleIntegerProperty()
    var maxTemp by maxTempProperty

    val minTempProperty = SimpleIntegerProperty()
    var minTemp by minTempProperty

    val apparentMaxTempProperty = SimpleIntegerProperty()
    var apparentMaxTemp by apparentMaxTempProperty

    val apparentMinTempProperty = SimpleIntegerProperty()
    var apparentMinTemp by apparentMinTempProperty

    val highTempProperty = SimpleIntegerProperty()
    var highTemp by highTempProperty

    val lowTempProperty = SimpleIntegerProperty()
    var lowTemp by lowTempProperty

    val pressureProperty = SimpleIntegerProperty()
    var pressure by pressureProperty

    val seaLevelPressureProperty = SimpleIntegerProperty()
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
            timestamp = getInt("ts")
            sunriseTimestamp = getInt("sunrise_ts")
            sunsetTimestamp = getInt("sunset_ts")
            weather = getJsonObject("weather").toModel()
            snow = getDouble("snow")
            snowDepth = getInt("snow_depth")
            precipitation = getDouble("precip")
            probabilityOfPrecipitation = getInt("pop")
            temperature = getInt("temp")
            maxTemp = getInt("max_temp")
            minTemp = getInt("min_temp")
            apparentMaxTemp = getInt("app_max_temp")
            apparentMinTemp = getInt("app_min_temp")
            highTemp = getInt("high_temp")
            lowTemp = getInt("low_temp")
            pressure = getInt("pres")
            seaLevelPressure = getInt("slp")
            clouds = getInt("clouds")
            cloudsLow = getInt("clouds_low")
            cloudsMid = getInt("clouds_mid")
            cloudsHi = getInt("clouds_hi")
            visibility = getInt("vis")
            humidity = getInt("rh")
            dewPoint = getInt("dewpt")
            uv = getDouble("uv")
            windSpeed = getDouble("wind_spd")
            windGustSpeed = getDouble("wind_gust_spd")
            windDirection = getInt("wind_dir")
            abbreviatedWindDirection = getString("wind_cdir")
            verbalWindDirection = getString("wind_cdir_full")
        }
    }
}