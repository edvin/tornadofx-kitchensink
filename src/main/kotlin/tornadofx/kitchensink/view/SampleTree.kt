package tornadofx.kitchensink.view

import javafx.scene.control.TreeItem
import tornadofx.*
import tornadofx.kitchensink.controller.SampleController
import tornadofx.kitchensink.model.SampleEntry
import tornadofx.kitchensink.model.SampleModel

class SampleTree : View() {
    val controller: SampleController by inject(DefaultScope)
    val model: SampleModel by inject()

    override val root = treeview<SampleEntry> {
        isShowRoot = false
        prefWidth = 200.0
        bindSelected(model)
        runAsync {
            controller.root
        } ui {
            root = TreeItem(it)
            populate { (it.value as? SampleEntry.Category)?.samples }
        }
    }
}