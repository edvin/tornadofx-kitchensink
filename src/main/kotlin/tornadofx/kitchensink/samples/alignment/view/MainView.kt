package tornadofx.kitchensink.samples.alignment.view

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.effect.DropShadow
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import tornadofx.*

/**
 * A sample demonstrating the use of vbox constraints and alignment
 *
 */
class MainView : View("Alignment") {
    override val root = anchorpane {
        tilepane {
            prefRows = 3
            prefColumns = 3
            padding = Insets(40.0)
            hgap = 20.0
            vgap = 20.0

            Pos.values().forEach {
                vbox {
                    label(it.name)
                    alignment = it
                    background = Background(BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0)))
                    effect = DropShadow()
                    prefWidth = 150.0
                    prefHeight = 150.0
                }
            }
        }
    }
}
