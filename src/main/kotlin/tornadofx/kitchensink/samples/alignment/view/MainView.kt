package tornadofx.kitchensink.samples.alignment.view

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.effect.DropShadow
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

            vbox {
                label(Pos.TOP_LEFT.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.TOP_LEFT
            }

            vbox {
                label(Pos.TOP_CENTER.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.TOP_CENTER
            }

            vbox {
                label(Pos.TOP_RIGHT.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.TOP_RIGHT
            }

            vbox {
                label(Pos.CENTER_LEFT.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.CENTER_LEFT
            }

            vbox {
                label(Pos.CENTER.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.CENTER
            }

            vbox {
                label(Pos.CENTER_RIGHT.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.CENTER_RIGHT
            }

            vbox {
                label(Pos.BOTTOM_LEFT.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.BOTTOM_LEFT
            }

            vbox {
                label(Pos.BOTTOM_CENTER.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.BOTTOM_CENTER
            }

            vbox {
                label(Pos.BOTTOM_RIGHT.toString()) {
                    margin = Insets(10.0)
                }
                alignment = Pos.BOTTOM_RIGHT
            }

            children.style {
                backgroundColor += Color.TAN
                effect = DropShadow()
                prefWidth = 150.px
                prefHeight = 150.px
                padding = box(10.px)
            }
        }
    }

}
