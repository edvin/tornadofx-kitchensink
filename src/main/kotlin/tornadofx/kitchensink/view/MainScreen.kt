package tornadofx.kitchensink.view

import tornadofx.*

class MainScreen : View("TornadoFX Samples") {
    override val root = hbox {
        add<SampleTree>()
        add<SampleViewer>()
    }
}