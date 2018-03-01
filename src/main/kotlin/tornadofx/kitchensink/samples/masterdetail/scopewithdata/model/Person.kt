package tornadofx.kitchensink.samples.masterdetail.scopewithdata.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*

class Person(id: Int, name: String, phoneNumbers: List<PhoneNumber>) {
    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty

    val phoneNumbersProperty = FXCollections.observableArrayList(phoneNumbers)
}

class PersonModel(person: Person? = null): ItemViewModel<Person>(person) {
    val id = bind(Person::idProperty)
    val name = bind(Person::nameProperty)
    val phoneNumbers = bind(Person::phoneNumbersProperty)

    fun addPhoneNumber(phoneNumber: PhoneNumber) {
        phoneNumbers.value.add(phoneNumber)
    }

    fun removePhoneNumber(phoneNumber: PhoneNumber) {
        phoneNumbers.value.remove(phoneNumber)
    }
}


class PersonScope : Scope() {
    val model = PersonModel()
}