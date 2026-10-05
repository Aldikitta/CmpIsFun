package com.kotlintoolchain.aldikitta.screen.connectivity

import kotlinx.coroutines.flow.Flow

expect class ConnectivityObserver {
    val connectionStatus: Flow<ConnectionStatus>
}