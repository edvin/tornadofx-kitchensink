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
 * A sample demonstrating the use of vboxConstraints and alignment
 *
 */
class MainView : View("Alignment") {
	
    override val root =
			anchorpane {

				tilepane {

					prefRows = 3
					prefColumns = 3
					padding = Insets(40.0)
					hgap = 20.0
					vgap = 20.0

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("TOP_LEFT")
						vboxConstraints {
							alignment = Pos.TOP_LEFT
						}
					}

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("TOP_CENTER")
						vboxConstraints {
							alignment = Pos.TOP_CENTER
						}
					}

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("TOP_RIGHT")
						vboxConstraints {
							alignment = Pos.TOP_RIGHT
						}
					}

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("CENTER_LEFT")
						vboxConstraints {
							alignment = Pos.CENTER_LEFT
						}
					}

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("CENTER")
						vboxConstraints {
							alignment = Pos.CENTER
						}
					}

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("CENTER_RIGHT")
						vboxConstraints {
							alignment = Pos.CENTER_RIGHT
						}
					}

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("BOTTOM_LEFT")
						vboxConstraints {
							alignment = Pos.BOTTOM_LEFT
						}
					}

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("BOTTOM_CENTER")
						vboxConstraints {
							alignment = Pos.BOTTOM_CENTER
						}
					}

					vbox {
						background = Background(
								BackgroundFill(Color.TAN, CornerRadii(0.0), Insets(0.0))
						)
						effect = DropShadow()
						prefWidth = 150.0
						prefHeight = 150.0
						label("BOTTOM_RIGHT")
						vboxConstraints() {
							alignment = Pos.BOTTOM_RIGHT
						}
					}
				}
			}
}
