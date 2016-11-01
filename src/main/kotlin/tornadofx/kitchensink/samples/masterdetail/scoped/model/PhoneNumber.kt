package tornadofx.kitchensink.samples.masterdetail.scoped.model

import tornadofx.getProperty
import tornadofx.property

class PhoneNumber(countryCode: String, number: String) {
    var countryCode by property(countryCode)
    fun countryCodeProperty() = getProperty(PhoneNumber::countryCode)

    var number by property(number)
    fun numberProperty() = getProperty(PhoneNumber::number)
}
