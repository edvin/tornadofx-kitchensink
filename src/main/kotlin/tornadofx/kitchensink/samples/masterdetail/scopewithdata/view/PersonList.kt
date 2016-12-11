package tornadofx.kitchensink.samples.masterdetail.scopewithdata.view

import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.scopewithdata.controller.PersonController
import tornadofx.kitchensink.samples.masterdetail.scopewithdata.model.Person
import tornadofx.kitchensink.samples.masterdetail.scopewithdata.model.PersonScope

class PersonList : View() {
    val controller : PersonController by inject()

    override val root = tableview(controller.persons) {
        prefWidth = 400.0
        column("Id", Person::idProperty)
        column("Name", Person::nameProperty)
        onUserSelect { editPerson(it) }
        columnResizePolicy = SmartResize.POLICY
    }

    fun editPerson(person: Person) {
        val editScope = PersonScope()
        editScope.model.item = person
        find(PersonEditor::class, editScope).openWindow()
    }
}