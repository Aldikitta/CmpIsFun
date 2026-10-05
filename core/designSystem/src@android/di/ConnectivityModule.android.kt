package com.kotlintoolchain.aldikitta.di

import android.content.Context
import com.kotlintoolchain.aldikitta.screen.connectivity.ConnectivityObserver
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.context.GlobalContext

@Module
actual class ConnectivityModule {
    @Single
    actual fun provideConnectivityObserver(): ConnectivityObserver {
        val context: Context = GlobalContext.get().get()
        return ConnectivityObserver(context)
    }
}