@file:Suppress("UNCHECKED_CAST")

package tornadofx.kitchensink.view

import javafx.scene.layout.Priority
import javafx.scene.layout.StackPane
import javafx.scene.web.WebView
import tornadofx.*
import tornadofx.kitchensink.model.SampleEntry
import tornadofx.kitchensink.model.SampleModel

class SampleViewer : View() {
    val model: SampleModel by inject()

    override val root = tabpane {
        hboxConstraints { hGrow = Priority.ALWAYS }
        tab("Example") {
            stackpane {
                loadCodeSampleOnChange()
            }
        }
        tab("Code and Description") {
            webview {
                loadReadmeOnChange()
            }
        }
        tabs.forEach { it.isClosable = false }
    }

    private fun WebView.loadReadmeOnChange() {
        model.itemProperty.onChange {
            if (it is SampleEntry.Sample) {
                engine.load(it.baseURL)
            }
        }
    }

    private fun StackPane.loadCodeSampleOnChange() {
        model.itemProperty.onChange {
            if (it is SampleEntry.Sample) {
                runAsync {
                    find(it.mainViewType)
                } ui {
                    children.setAll(it.root)
                }
            }
        }
    }

}