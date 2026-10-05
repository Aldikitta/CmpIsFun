package com.kotlintoolchain.aldikitta

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.kotlintoolchain.aldikitta.di.KoinInitializer

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    KoinInitializer().init()
    ComposeViewport {
        App()
    }
}
