package com.kotlintoolchain.aldikitta.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kotlintoolchain.aldikitta.LocalAppLocale
import org.jetbrains.compose.resources.getString
import org.koin.compose.koinInject
import com.kotlintoolchain.aldikitta.resources.Res
import com.kotlintoolchain.aldikitta.resources.internet_connected
import com.kotlintoolchain.aldikitta.resources.internet_not_connected
import com.kotlintoolchain.aldikitta.screen.connectivity.ConnectionStatus
import com.kotlintoolchain.aldikitta.screen.connectivity.ConnectivityObserver
import com.kotlintoolchain.aldikitta.screen.property.NavigationBarProperty

@Composable
fun CmpIsFunScreen(
    titleTopBar: String? = "",
    content: @Composable ((PaddingValues) -> Unit) = {},
    navigationBarProperty: NavigationBarProperty = NavigationBarProperty(),
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val connectivityObserver: ConnectivityObserver = koinInject()
    val connectionStatus by connectivityObserver.connectionStatus.collectAsState(initial = ConnectionStatus.Available)

    var customAppLocale by mutableStateOf<String?>(null)

    LaunchedEffect(connectionStatus) {
        snackBarHostState.currentSnackbarData?.dismiss()
        val message = if (connectionStatus == ConnectionStatus.Available) {
            getString(Res.string.internet_connected)
        } else {
            getString(Res.string.internet_not_connected)
        }
        snackBarHostState.showSnackbar(
            message = message,
            duration = SnackbarDuration.Short
        )
    }

    CompositionLocalProvider(
        LocalAppLocale provides customAppLocale,
    ) {
        key(customAppLocale) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(text = titleTopBar.orEmpty())
                        }
                    )
                },
                snackbarHost = {
                    SnackbarHost(snackBarHostState)
                },
                bottomBar = {
                    if (navigationBarProperty.navBarItems.isNotEmpty()) {
                        NavigationBar {
                            navigationBarProperty.navBarItems.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            imageVector = if (navigationBarProperty.selectedNavBarItem == index) navigationBarProperty.selectedNavBarIcons[index]
                                            else navigationBarProperty.unselectedNavBarIcons[index],
                                            contentDescription = item,
                                        )
                                    },
                                    label = { Text(item) },
                                    selected = navigationBarProperty.selectedNavBarItem == index,
                                    onClick = { navigationBarProperty.onNavBarItemSelected(index) }
                                )
                            }
                        }
                    }
                },
                content = content
            )
        }
    }
}