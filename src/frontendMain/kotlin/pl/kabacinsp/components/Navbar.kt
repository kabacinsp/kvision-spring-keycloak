package pl.kabacinsp.components

import io.kvision.core.Container
import io.kvision.form.check.checkBoxInput
import io.kvision.html.*

fun Container.navbar(primary: Boolean = true) {
    nav(className = "navbar navbar-expand-lg navbar-light bg-light w-100") {
        link("Title", "#", className = "navbar-brand")
        button("", type = ButtonType.BUTTON, className = "navbar-toggler") {
            setAttribute("data-toggle", "collapse")
            setAttribute("data-target", "#navbarToggle")
            setAttribute("aria-controls", "#navbarToggle")
            setAttribute("aria-expanded", "false")
            setAttribute("aria-label", "Toggle navigation")
            span {
                addCssClass("navbar-toggler-icon")
            }
        }
        div(className = "collapse navbar-collapse") {
            id = "navbarToggle"
            div(className = "navbar-nav mr-auto mt-2 mt-lg-0") {
                link("Home", "#", className = "nav-link")
                link("About", "#", className = "nav-link")
            }
            div(className = "navbar-nav my-2 my-lg-0") {
                link("Login", "#", className = "nav-link")
                link("Sign in", "#", className = "nav-link")
                link("", className = "nav-link") {
                    div(className = "custom-control custom-switch") {
                        checkBoxInput(value = true) {
                            addCssClass("custom-control-input")
                            id = "themeSwitch"
                        }
                        label(forId = "themeSwitch", content = "") {
                            addCssClass("custom-control-label")
                        }
                    }
                }
            }
        }
    }
}