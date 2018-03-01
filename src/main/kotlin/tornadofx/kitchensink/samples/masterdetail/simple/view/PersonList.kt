package tornadofx.kitchensink.samples.masterdetail.simple.view

import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.simple.controller.PersonController
import tornadofx.kitchensink.samples.masterdetail.simple.model.Person
import tornadofx.kitchensink.samples.masterdetail.simple.model.PersonModel

class PersonList : View() {
    private val controller : PersonController by inject()
    private val model : PersonModel by inject()

    override val root = tableview(controller.persons) {
        column("Id", Person::idProperty)
        column("Name", Person::nameProperty)
        bindSelected(model)
        smartResize()
    }
}