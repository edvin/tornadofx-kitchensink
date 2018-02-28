package tornadofx.kitchensink.samples.masterdetail.simple.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class PhoneNumber(countryCode: String, number: String) {
    val countryCodeProperty = SimpleStringProperty(countryCode)
    var countryCode by countryCodeProperty

    val numberProperty = SimpleStringProperty(number)
    var number by property(number)
}