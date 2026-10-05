package com.kotlintoolchain.aldikitta.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.kotlintoolchain.aldikitta.DashboardNavGraph
import com.kotlintoolchain.aldikitta.DashboardScreen
import com.kotlintoolchain.aldikitta.screen.CmpIsFunScreenViewModel

fun NavGraphBuilder.dashboardGraph(
    screenViewModel: CmpIsFunScreenViewModel,
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit
) {
    navigation<DashboardNavGraph>(
        startDestination = DashboardScreen
    ) {
        dashboardScreen(
            screenViewModel = screenViewModel,
            navigateToMovie = navigateToMovie,
            navigateToEcommerce = navigateToEcommerce,
            navigateToCmpPlayground = navigateToCmpPlayground
        )
    }
}