package tornadofx.kitchensink.samples.masterdetail.simple.view

import javafx.geometry.Pos
import javafx.scene.control.TableView
import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.simple.model.PersonModel
import tornadofx.kitchensink.samples.masterdetail.simple.model.PhoneNumber

class PersonEditor : View() {
    private val model: PersonModel by inject()
    private var numbersTable: TableView<PhoneNumber> by singleAssign()

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
                    numbersTable = this
                    smartResize()
                    column("Country code", PhoneNumber::countryCodeProperty).makeEditable()
                    column("Number", PhoneNumber::numberProperty).makeEditable()
                }
                hbox {
                    alignment = Pos.TOP_CENTER
                    spacing = 10.0
                    button("Add Number").action(::addPhoneNumber)
                    button("Delete Number") {
                        disableWhen { numbersTable.selectionModel.selectedItemProperty().isNull } // disables when nothing is selected
                        action(::deletePhoneNumber)
                    }
                }
            }
        }
    }

    private fun addPhoneNumber() {
        val newNumber = PhoneNumber("", "")
        model.addPhoneNumber(newNumber)
        numbersTable.selectionModel.select(newNumber)
        numbersTable.edit(numbersTable.items.size - 1, numbersTable.columns.first())
    }

    private fun deletePhoneNumber() {
        numbersTable.selectedItem?.let(model::removePhoneNumber)
    }
}
