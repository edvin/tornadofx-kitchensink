@file:Suppress("UNCHECKED_CAST")

package tornadofx.kitchensink.model

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.ItemViewModel
import javax.json.JsonObject

sealed class SampleEntry {
    val name = SimpleStringProperty()

    override fun toString() = name.value

    open class Category(json: JsonObject) : SampleEntry() {
        val samples = FXCollections.observableArrayList<SampleEntry>()

        init {
            name.value = json.getString("name")
            samples.setAll(json.getJsonArray("samples").map {
                it as JsonObject
                if (it.containsKey("samples")) Category(it) else Sample(it)
            })
        }
    }

    class Sample(json: JsonObject) : SampleEntry() {
        init {
            name.value = json.getString("name")
        }
        val entrypoint = json.getString("entrypoint")
    }
}

class SampleModel : ItemViewModel<SampleEntry>() {
    val name = bind { item?.name }
}