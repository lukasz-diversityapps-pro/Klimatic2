package model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Data : JsonModel {
    val timestampProperty = SimpleIntegerProperty()
    var timestamp by timestampProperty


//    "timestamp_local": "2019-03-04T12:00:00",
//    "timestamp_utc": "2019-03-04T17:00:00",
//    "datetime": "2019-03-04:17",

//    "snow": 10.45,
    val snowProperty = SimpleDoubleProperty()
    var snow by snowProperty

//    "snow_depth": 45,
    val snowDepthProperty = SimpleIntegerProperty()
    var snowDepth by snowDepthProperty

//    "precip": 1.1,
    val precipitationProperty = SimpleDoubleProperty()
    var precipitation by precipitationProperty

//    "temp": 1,
    val temperatureProperty = SimpleIntegerProperty()
    var temperature by temperatureProperty

//    "dewpt": 1,
    val dewPointProperty = SimpleIntegerProperty()
    var dewPoint by dewPointProperty


//    "max_temp": 1.5,
    val maxTempProperty = SimpleDoubleProperty()
    var maxTemp by maxTempProperty

//    "min_temp": -1.23,
    val minTempProperty = SimpleDoubleProperty()
    var minTemp by minTempProperty

//    "app_max_temp": 4,
//    "app_min_temp": -2,


//    "rh": 95,
//    "clouds": 100,
//    "weather": {},
//    "slp": 1012.89,

//    "pres": 1005,
    val pressureProperty = SimpleIntegerProperty()
    var pressure by pressureProperty

//    "uv": 6.5,
    val uvProperty = SimpleDoubleProperty()
    var uv by uvProperty

//    "max_dhi": "655",
//    "vis": 3,
//    "pop": 75,

//    "sunrise_ts": 1530331260,
    val sunriseTimestampProperty = SimpleIntegerProperty()
    var sunriseTimestamp by sunriseTimestampProperty

//    "sunset_ts": 1530331260,
    val sunsetTimestampProperty = SimpleIntegerProperty()
    var sunsetTimestamp by sunsetTimestampProperty

//    "pod": "n",
//    "wind_spd": 13.85,
    val windSpeedProperty = SimpleDoubleProperty()
    var windSpeed by windSpeedProperty

//    "wind_dir": 105,
    val windDirectionProperty = SimpleIntegerProperty()
    var windDirection by windDirectionProperty


}