package tornadofx.kitchensink.samples.masterdetail.scope.model

import javafx.collections.FXCollections
import tornadofx.ItemViewModel
import tornadofx.getProperty
import tornadofx.property

class Person(id: Int, name: String, phoneNumbers: List<PhoneNumber>) {
    var id by property(id)
    fun idProperty() = getProperty(Person::id)

    var name by property(name)
    fun nameProperty() = getProperty(Person::name)

    var phoneNumbers by property(FXCollections.observableArrayList(phoneNumbers))
    fun phoneNumbersProperty() = getProperty(Person::phoneNumbers)
}

class PersonModel : ItemViewModel<Person>() {
    val id = bind { item?.idProperty() }
    val name = bind { item?.nameProperty() }
    val phoneNumbers = bind { item?.phoneNumbersProperty() }
}