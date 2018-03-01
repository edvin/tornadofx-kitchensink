package tornadofx.kitchensink.controller

import tornadofx.Controller
import tornadofx.kitchensink.model.SampleEntry
import javax.json.Json

class SampleController : Controller() {
    val root: SampleEntry.Category by lazy {
        SampleEntry.Category(Json.createReader(resources.url("/samples.json").openStream()).readObject())
    }
}