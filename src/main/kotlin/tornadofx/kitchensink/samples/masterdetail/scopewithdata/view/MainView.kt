package tornadofx.kitchensink.samples.masterdetail.scopewithdata.view

import tornadofx.View
import tornadofx.hbox

class MainView : View("Person Editor - double click to edit") {
    override val root = hbox {
        this += PersonList::class
    }
}
