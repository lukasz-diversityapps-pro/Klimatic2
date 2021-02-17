package com.luki.klimatic.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class Weather : JsonModel {
    private val iconProperty = SimpleStringProperty()
    var icon by iconProperty

    private val codeProperty = SimpleIntegerProperty()
    private var code by codeProperty

    private val descriptionProperty = SimpleStringProperty()
    private var description by descriptionProperty

    override fun updateModel(json: JsonObject) {
        with(json) {
            icon = getString("icon")
            code = getInt("code")
            description = getString("description")
        }
    }
}