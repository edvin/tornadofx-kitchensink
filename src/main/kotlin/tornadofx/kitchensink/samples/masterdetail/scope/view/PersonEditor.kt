package tornadofx.kitchensink.samples.masterdetail.scope.view

import javafx.geometry.Pos
import javafx.scene.control.TableView
import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.scope.model.PersonModel
import tornadofx.kitchensink.samples.masterdetail.scope.model.PhoneNumber

class PersonEditor : View() {
    private val model : PersonModel by inject()
    private var numbersTable: TableView<PhoneNumber> by singleAssign()

    override val root = form {
        fieldset("Personal Information") {
            field("Name") {
                textfield(model.name)
            }
            button("Save") {
                setOnAction {
                    model.commit()
                }
            }
        }
        fieldset("Phone Numbers") {
            vbox(5.0) {
                tableview<PhoneNumber> {
                    numbersTable = this
                    prefHeight = 200.0
                    isEditable = true
                    columnResizePolicy = SmartResize.POLICY
                    column("Country code", PhoneNumber::countryCodeProperty).makeEditable()
                    column("Number", PhoneNumber::numberProperty).makeEditable()
                    itemsProperty().bind(model.phoneNumbers)
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
