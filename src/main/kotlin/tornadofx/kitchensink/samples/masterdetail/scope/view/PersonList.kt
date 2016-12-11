package tornadofx.kitchensink.samples.masterdetail.scope.view

import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.simple.controller.PersonController
import tornadofx.kitchensink.samples.masterdetail.simple.model.Person
import tornadofx.kitchensink.samples.masterdetail.simple.model.PersonModel

class PersonList : View() {
    val controller : PersonController by inject()

    override val root = tableview(controller.persons) {
        prefWidth = 400.0
        column("Id", Person::idProperty)
        column("Name", Person::nameProperty)
        onUserSelect { edit(it) }
        columnResizePolicy = SmartResize.POLICY
    }

    fun edit(person: Person) {
        val editScope = Scope()
        val model = PersonModel()
        model.item = person
        setInScope(model, editScope)
        find(PersonEditor::class, editScope).openWindow()
    }
}