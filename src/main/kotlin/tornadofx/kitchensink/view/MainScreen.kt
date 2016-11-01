package tornadofx.kitchensink.view

import tornadofx.*

class MainScreen : View("TornadoFX Samples") {
    override val root = hbox {
        this += SampleTree::class
        this += SampleViewer::class
    }
}