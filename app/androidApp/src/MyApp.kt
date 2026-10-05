package com.kotlintoolchain.aldikitta

import android.app.Application
import com.kotlintoolchain.aldikitta.di.KoinInitializer

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}