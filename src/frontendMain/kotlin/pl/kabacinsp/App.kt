package pl.kabacinsp

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import io.kvision.Application
import io.kvision.form.check.checkBoxInput
import io.kvision.html.*
import io.kvision.i18n.DefaultI18nManager
import io.kvision.i18n.I18n
import io.kvision.module
import io.kvision.panel.ContainerType
import pl.kabacinsp.components.navbar
import io.kvision.panel.root
import io.kvision.panel.vPanel
import io.kvision.require
import io.kvision.startApplication

class App : Application() {
    init {
        require("sass/style.scss")
    }

    override fun start(state: Map<String, Any>) {
        I18n.manager =
            DefaultI18nManager(
                mapOf(
                    "en" to io.kvision.require("i18n/messages-en.json"),
                    "pl" to io.kvision.require("i18n/messages-pl.json")
                )
            )
        val root = root("kvapp") {
            navbar()

            div (className = "container-fluid") {
                image(require("images/kvision.svg") as? String, alt = "Centered dog in a circle", centered = true) {
                    addCssClass("w-25")
                    addCssClass("mx-auto")
                    addCssClass("d-block")
                }
            }
        }
        GlobalScope.launch {
            val pingResult = Model.ping("Hello world from client!")
            root.add(Div(pingResult) {
                addCssClass("container-fluid")
                addCssClass("text-center")
            })
        }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
