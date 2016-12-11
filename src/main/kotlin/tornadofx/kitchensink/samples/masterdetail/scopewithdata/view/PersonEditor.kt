package tornadofx.kitchensink.samples.masterdetail.scopewithdata.view

import javafx.scene.control.TableView
import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.scopewithdata.model.PersonScope
import tornadofx.kitchensink.samples.masterdetail.scopewithdata.model.PhoneNumber

class PersonEditor : View() {
    override val scope = super.scope as PersonScope
    val model = scope.model
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
                    prefHeight = 200.0
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
