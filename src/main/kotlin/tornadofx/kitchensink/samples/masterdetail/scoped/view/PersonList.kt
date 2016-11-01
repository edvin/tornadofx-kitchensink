package tornadofx.kitchensink.samples.masterdetail.scoped.view

import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.scoped.controller.PersonController
import tornadofx.kitchensink.samples.masterdetail.scoped.model.Person
import tornadofx.kitchensink.samples.masterdetail.scoped.model.PersonModel

class PersonList : View() {
    val controller : PersonController by inject()
    val model : PersonModel by inject()

    override val root = tableview(controller.persons) {
        column("Id", Person::idProperty)
        column("Name", Person::nameProperty)
        bindSelected(model)
        columnResizePolicy = SmartResize.POLICY
    }
}