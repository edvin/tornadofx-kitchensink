package tornadofx.kitchensink.samples.masterdetail.simple.view

import tornadofx.*

class MainView : View("Person Editor") {
    override val root = hbox {
        add<PersonList>()
        add<PersonEditor>()
    }
}
