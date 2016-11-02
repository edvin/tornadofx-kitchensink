package tornadofx.kitchensink.app

import com.jpro.JProApplication
import com.jpro.WebAPI
import javafx.scene.Scene
import javafx.scene.control.ListView
import javafx.scene.control.TableView
import javafx.stage.Stage
import tornadofx.*
import tornadofx.kitchensink.samples.masterdetail.simple.controller.PersonController
import tornadofx.kitchensink.samples.masterdetail.simple.model.PhoneNumber
import tornadofx.kitchensink.view.MainScreen

class KitchenSinkApp : App(MainScreen::class, Styles::class)

class JProScope(val stage: Stage) : Scope() {
    val webAPI: WebAPI get() = WebAPI.getWebAPI(stage)
}

val Component.webAPI: WebAPI get() = (scope as JProScope).webAPI

class Main : JProApplication() {
    val app = KitchenSinkApp()

    override fun start(primaryStage: Stage) {
        app.scope = JProScope(primaryStage)
        app.start(primaryStage)
    }

    override fun stop() {
        app.stop()
        super.stop()
    }
}