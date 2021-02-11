package model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate

class Data : JsonModel {
    val validDateProperty = SimpleObjectProperty<LocalDate>()
    var validDate by validDateProperty

    val timestampProperty = SimpleIntegerProperty()
    var timestamp by timestampProperty

    // "sunrise_ts": 1530331260,
    val sunriseTimestampProperty = SimpleIntegerProperty()
    var sunriseTimestamp by sunriseTimestampProperty

    // "sunset_ts": 1530331260,
    val sunsetTimestampProperty = SimpleIntegerProperty()
    var sunsetTimestamp by sunsetTimestampProperty



    // "weather": {}
    val weatherProperty = SimpleObjectProperty<Weather>()
    var weather by weatherProperty



    // "snow": 10.45,
    val snowProperty = SimpleDoubleProperty()
    var snow by snowProperty

    // "snow_depth": 45,
    val snowDepthProperty = SimpleIntegerProperty()
    var snowDepth by snowDepthProperty



    // "precip": 1.1,
    val precipitationProperty = SimpleDoubleProperty()
    var precipitation by precipitationProperty

    // pop: Probability of Precipitation (%)
    val probabilityOfPrecipitationProperty = SimpleIntegerProperty()
    var probabilityOfPrecipitation by probabilityOfPrecipitationProperty



    // "temp": 1,
    val temperatureProperty = SimpleIntegerProperty()
    var temperature by temperatureProperty

    // "max_temp": 1.5,
    val maxTempProperty = SimpleIntegerProperty()
    var maxTemp by maxTempProperty

    // "min_temp": -1.23,
    val minTempProperty = SimpleIntegerProperty()
    var minTemp by minTempProperty

    // "app_max_temp": 1.5,
    val apparentMaxTempProperty = SimpleIntegerProperty()
    var apparentMaxTemp by apparentMaxTempProperty

    // "app_min_temp": -1.23,
    val apparentMinTempProperty = SimpleIntegerProperty()
    var apparentMinTemp by apparentMinTempProperty

    // "high_temp": 1.5,
    val highTempProperty = SimpleIntegerProperty()
    var highTemp by highTempProperty

    // "low_temp": -1.23,
    val lowTempProperty = SimpleIntegerProperty()
    var lowTemp by lowTempProperty



    // "pres": 1005,
    val pressureProperty = SimpleIntegerProperty()
    var pressure by pressureProperty

    val seaLevelPressureProperty = SimpleIntegerProperty()
    var seaLevelPressure by seaLevelPressureProperty



    // "clouds": 100,
    val cloudsProperty = SimpleIntegerProperty()
    var clouds by cloudsProperty

    // clouds_low: Low-level (~0-3km AGL) cloud coverage (%)
    val cloudsLowProperty = SimpleIntegerProperty()
    var cloudsLow by cloudsLowProperty

    // clouds_mid: Mid-level (~3-5km AGL) cloud coverage (%)
    val cloudsMidProperty = SimpleIntegerProperty()
    var cloudsMid by cloudsMidProperty

    // clouds_hi: High-level (>5km AGL) cloud coverage (%)
    val cloudsHiProperty = SimpleIntegerProperty()
    var cloudsHi by cloudsHiProperty

    // "vis": 3,
    val visibilityProperty = SimpleIntegerProperty()
    var visibility by visibilityProperty

    // "rh": 95,
    val humidityProperty = SimpleIntegerProperty()
    var humidity by humidityProperty

    // "dewpt": 1,
    val dewPointProperty = SimpleIntegerProperty()
    var dewPoint by dewPointProperty

    // "uv": 6.5,
    val uvProperty = SimpleDoubleProperty()
    var uv by uvProperty



    // "wind_spd": 13.85,
    val windSpeedProperty = SimpleDoubleProperty()
    var windSpeed by windSpeedProperty

    // "wind_gust_spd"
    val windGustSpeedProperty = SimpleDoubleProperty()
    var windGustSpeed by windGustSpeedProperty

    // "wind_dir": 105,
    val windDirectionProperty = SimpleIntegerProperty()
    var windDirection by windDirectionProperty

    // "wind_cdir"
    val abbreviatedWindDirectionProperty = SimpleStringProperty()
    var abbreviatedWindDirection by abbreviatedWindDirectionProperty

    // "wind_cdir_full"
    val verbalWindDirectionProperty = SimpleStringProperty()
    var verbalWindDirection by verbalWindDirectionProperty
}