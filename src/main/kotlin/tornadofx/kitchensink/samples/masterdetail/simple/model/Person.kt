package tornadofx.kitchensink.samples.masterdetail.simple.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Person(id: Int, name: String, phoneNumbers: List<PhoneNumber>) {
    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty

    val phoneNumbersProperty = SimpleListProperty<PhoneNumber>(phoneNumbers.observable())
    var phoneNumbers by phoneNumbersProperty
}

class PersonModel : ItemViewModel<Person>() {
    val id = bind(Person::idProperty)
    val name = bind(Person::nameProperty)
    val phoneNumbers = bind(Person::phoneNumbersProperty)
}



