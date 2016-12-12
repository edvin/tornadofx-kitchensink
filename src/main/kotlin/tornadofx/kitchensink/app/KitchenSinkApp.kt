package tornadofx.kitchensink.app

import tornadofx.App
import tornadofx.kitchensink.view.MainScreen

class KitchenSinkApp : App(MainScreen::class, Styles::class)

/*
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
*/