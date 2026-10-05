package com.kotlintoolchain.aldikitta

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "com.kotlintoolchain.aldikitta") {
        App()
    }
}
