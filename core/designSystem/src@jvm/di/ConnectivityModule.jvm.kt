package com.kotlintoolchain.aldikitta.di

import com.kotlintoolchain.aldikitta.screen.connectivity.ConnectivityObserver
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
actual class ConnectivityModule {
    @Single
    actual fun provideConnectivityObserver(): ConnectivityObserver {
        return ConnectivityObserver()
    }
}