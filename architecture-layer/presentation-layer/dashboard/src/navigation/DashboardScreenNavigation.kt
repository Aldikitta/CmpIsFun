package com.kotlintoolchain.aldikitta.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kotlintoolchain.aldikitta.DashboardScreen
import com.kotlintoolchain.aldikitta.screen.CmpIsFunScreenViewModel

fun NavGraphBuilder.dashboardScreen(
    screenViewModel: CmpIsFunScreenViewModel,
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit
) {
    composable<DashboardScreen> {
        DashboardScreen(
            screenViewModel = screenViewModel,
            navigateToMovie = navigateToMovie,
            navigateToEcommerce = navigateToEcommerce,
            navigateToCmpPlayground = navigateToCmpPlayground,
            navigateToDynamicForm = {},
            navigateToDsl = {}
        )
    }
}