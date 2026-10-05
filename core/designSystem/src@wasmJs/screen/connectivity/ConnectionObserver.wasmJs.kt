package com.kotlintoolchain.aldikitta.screen.connectivity

import kotlinx.browser.window
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.w3c.dom.events.Event

actual class ConnectivityObserver {

    actual val connectionStatus: Flow<ConnectionStatus> = callbackFlow {
        fun updateStatus() {
            trySend(
                if (window.navigator.onLine) {
                    ConnectionStatus.Available
                } else {
                    ConnectionStatus.Unavailable
                }
            )
        }

        val onlineListener: (Event) -> Unit = {
            trySend(ConnectionStatus.Available)
        }

        val offlineListener: (Event) -> Unit = {
            trySend(ConnectionStatus.Unavailable)
        }

        window.addEventListener("online", onlineListener)
        window.addEventListener("offline", offlineListener)

        // Emit initial state
        updateStatus()

        awaitClose {
            window.removeEventListener("online", onlineListener)
            window.removeEventListener("offline", offlineListener)
        }
    }
}
