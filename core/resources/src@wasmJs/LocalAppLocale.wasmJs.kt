package com.kotlintoolchain.aldikitta

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.browser.window

actual object LocalAppLocale {
    private val default = window.navigator.language

    private val LocalAppLocale = staticCompositionLocalOf { default }

    actual val current: String
        @Composable
        get() = LocalAppLocale.current

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        return LocalAppLocale.provides(value ?: default)
    }
}
