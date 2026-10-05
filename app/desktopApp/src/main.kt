package com.kotlintoolchain.aldikitta

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kotlintoolchain.aldikitta.di.KoinInitializer

fun main() = application {
    KoinInitializer().init()
    Window(onCloseRequest = ::exitApplication, title = "com.kotlintoolchain.aldikitta") {
        App()
    }
}
