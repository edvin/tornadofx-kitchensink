package tornadofx.kitchensink.samples.masterdetail.scope.view

import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.scope.controller.PersonController
import tornadofx.kitchensink.samples.masterdetail.scope.model.Person
import tornadofx.kitchensink.samples.masterdetail.scope.model.PersonModel

class PersonList : View() {
    private val controller : PersonController by inject()

    override val root = tableview(controller.persons) {
        prefWidth = 400.0
        smartResize()
        column("Id", Person::idProperty)
        column("Name", Person::nameProperty)
        onUserSelect { edit(it) }
    }

    private fun edit(person: Person) {
        val editScope = Scope()
        val model = PersonModel()
        model.item = person
        setInScope(model, editScope)
        find(PersonEditor::class, editScope).openWindow()
    }
}