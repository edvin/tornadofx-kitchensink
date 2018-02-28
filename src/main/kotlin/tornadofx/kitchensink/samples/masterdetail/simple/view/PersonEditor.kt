package tornadofx.kitchensink.samples.masterdetail.simple.view

import javafx.scene.control.TableView
import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.simple.model.PersonModel
import tornadofx.kitchensink.samples.masterdetail.simple.model.PhoneNumber

class PersonEditor : View() {
    val model: PersonModel by inject()
    val numbersTable: TableView<PhoneNumber> by singleAssign()

    override val root = form {
        fieldset("Personal Information") {
            field("Name") {
                textfield(model.name)
            }
            button("Save") {
                action {
                    model.commit()
                }
            }
        }
        fieldset("Phone Numbers") {
            vbox(5.0) {
                tableview(model.phoneNumbers) {
                    smartResize()
                    column("Country code", PhoneNumber::countryCodeProperty).makeEditable()
                    column("Number", PhoneNumber::numberProperty).makeEditable()
                }
                button("Add number") {
                    action {
                        val newNumber = PhoneNumber("", "")
                        model.phoneNumbers.value.add(newNumber)
                        numbersTable.selectionModel.select(newNumber)
                        numbersTable.edit(numbersTable.items.size - 1, numbersTable.columns.first())
                    }
                }
            }
        }
    }
}
