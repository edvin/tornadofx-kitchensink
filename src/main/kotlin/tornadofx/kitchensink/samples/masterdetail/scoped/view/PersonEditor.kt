package tornadofx.kitchensink.samples.masterdetail.scoped.view

import javafx.scene.control.TableView
import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.scoped.model.PersonModel
import tornadofx.kitchensink.samples.masterdetail.scoped.model.PhoneNumber

class PersonEditor : View() {
    val model : PersonModel by inject()
    var numbersTable: TableView<PhoneNumber> by singleAssign()

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
                    isEditable = true
                    columnResizePolicy = SmartResize.POLICY
                    column("Country code", PhoneNumber::countryCodeProperty).makeEditable()
                    column("Number", PhoneNumber::numberProperty).makeEditable()
                    itemsProperty().bind(model.phoneNumbers)
                }
                button("Add number") {
                    setOnAction {
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
