package com.kotlintoolchain.aldikitta.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.KoinApplication
import org.koin.plugin.module.dsl.startKoin

actual class KoinInitializer(
    private val context: Context
) {
    actual fun init() {
        @KoinApplication(modules = [DesignSystemModule::class, ConnectivityModule::class])
        class MyApp

        startKoin<MyApp> {
            androidContext(context)
            androidLogger()
        }
    }
}