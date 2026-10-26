package com.kotlintoolchain.aldikitta.di

import org.koin.core.annotation.KoinApplication
import org.koin.plugin.module.dsl.startKoin

actual class KoinInitializer {
    actual fun init() {
        @KoinApplication(modules = [DesignSystemModule::class, ConnectivityModule::class])
        class MyApp

        startKoin<MyApp>()
    }
}