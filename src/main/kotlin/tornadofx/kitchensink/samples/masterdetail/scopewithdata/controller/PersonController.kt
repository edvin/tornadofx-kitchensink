package tornadofx.kitchensink.samples.masterdetail.scopewithdata.controller

import javafx.collections.FXCollections
import tornadofx.Controller
import tornadofx.kitchensink.samples.masterdetail.scopewithdata.model.Person
import tornadofx.kitchensink.samples.masterdetail.scopewithdata.model.PhoneNumber

class PersonController : Controller() {
    val persons = FXCollections.observableArrayList<Person>()

    init {
        // Add some test persons for the demo
        persons.add(Person(42, "John Doe", listOf(PhoneNumber("47", "33349700"), PhoneNumber("47", "333943222"))))
        persons.add(Person(43, "Jane Doe", listOf(PhoneNumber("1", "312 213 21"))))
    }
}
