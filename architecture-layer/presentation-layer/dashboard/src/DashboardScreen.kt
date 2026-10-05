package com.kotlintoolchain.aldikitta

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kotlintoolchain.aldikitta.screen.CmpIsFunScreen
import com.kotlintoolchain.aldikitta.screen.CmpIsFunScreenViewModel
import com.kotlintoolchain.aldikitta.screen.property.NavigationBarProperty
import com.kotlintoolchain.aldikitta.screens.HomeScreen
import com.kotlintoolchain.aldikitta.screens.MenuScreens

@Composable
fun DashboardScreen(
    screenViewModel: CmpIsFunScreenViewModel,
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit,
    navigateToDynamicForm: () -> Unit,
    navigateToDsl: () -> Unit,
) {
    val items = listOf(MenuScreens.HOME, MenuScreens.PROFILE, MenuScreens.SETTINGS)
    var selectedNavBarItem by remember { mutableIntStateOf(MenuScreens.HOME.id) }

    CmpIsFunScreen(
        titleTopBar = "Dashboard",
        navigationBarProperty = NavigationBarProperty(
            navBarItems = items.map { it.title },
            selectedNavBarItem = selectedNavBarItem,
            selectedNavBarIcons = items.map { it.selectedIcons },
            unselectedNavBarIcons = items.map { it.unselectedIcons },
            onNavBarItemSelected = { index -> selectedNavBarItem = index },
        ),
        content = { paddingValues ->
            when (items[selectedNavBarItem]) {
                MenuScreens.HOME -> {
                    HomeScreen(
                        paddingValues = paddingValues,
                        navigateToMovie = navigateToMovie,
                        navigateToEcommerce = navigateToEcommerce,
                        navigateToCmpPlayground = navigateToCmpPlayground,
                        navigateToDynamicForm = navigateToDynamicForm,
                        navigateToDsl = navigateToDsl,
                    )
                }
                MenuScreens.PROFILE -> {
                    // ProfileScreen(paddingValues)
                }
                MenuScreens.SETTINGS -> {
                    // SettingsScreen(paddingValues)
                }
            }
        }
    )
}