@file:Suppress("UNCHECKED_CAST")

package tornadofx.kitchensink.view

import javafx.scene.layout.Priority
import javafx.scene.layout.StackPane
import javafx.scene.web.WebView
import tornadofx.*
import tornadofx.kitchensink.model.SampleEntry
import tornadofx.kitchensink.model.SampleModel
import kotlin.reflect.KClass

class SampleViewer : View() {
    val model: SampleModel by inject()
    val exampleContent by cssid()
    val codeView by cssid()
    val descriptionView by cssid()

    override val root = tabpane {
        hboxConstraints { hGrow = Priority.ALWAYS }
        tab("Example") {
            isClosable = false
            stackpane {
                setId(exampleContent)
            }
        }
        tab("Code") {
            isClosable = false
            webview {
                setId(codeView)
            }
        }
        tab("Description") {
            isClosable = false
            webview {
                setId(descriptionView)
            }
        }
    }

    init {
        // Clear stackpane and show Sample on selection change
        model.itemProperty.onChange {
            if (it is SampleEntry.Sample) {
                val content = root.select<StackPane>(exampleContent)
                val codePane = root.select<WebView>(codeView)
                val descriptionPane = root.select<WebView>(descriptionView)

                val url = "https://github.com/edvin/tornadofx-kitchensink/tree/master/src/main/kotlin/${it.entrypoint.replace(".", "/")}"
                codePane.engine.load(url)
                descriptionPane.engine.loadContent("$url/README.md")

                runAsync {
                    find(Class.forName(it.entrypoint).kotlin as KClass<UIComponent>)
                } ui {
                    content.children.setAll(it.root)
                }
            }
        }
    }
}