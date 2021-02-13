package com.luki.klimatic.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class Weather : JsonModel {
    private val iconProperty = SimpleStringProperty()
    private var icon by iconProperty

    private val codeProperty = SimpleStringProperty()
    private var code by codeProperty

    private val descriptionProperty = SimpleStringProperty()
    private var description by descriptionProperty

    override fun updateModel(json: JsonObject) {
        with(json) {
            icon = getString("icon")
            code = getString("code")
            description = getString("description")
        }
    }
}