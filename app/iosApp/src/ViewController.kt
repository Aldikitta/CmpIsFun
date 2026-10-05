package com.kotlintoolchain.aldikitta

import androidx.compose.ui.window.ComposeUIViewController
import com.kotlintoolchain.aldikitta.di.KoinInitializer

fun ViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
){ App() }
