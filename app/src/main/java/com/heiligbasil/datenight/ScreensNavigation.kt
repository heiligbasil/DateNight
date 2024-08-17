package com.heiligbasil.datenight

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ScreensNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.Home) {
        composable<Screens.Home> {
            ScreenHome(onNavigateToScreenResults = {
                navHostController.navigate(route = Screens.Results)
            })
        }
        composable<Screens.Results> {
            ScreenResults(onNavigateToScreenDetails = {
                navHostController.navigate(route = Screens.Details)
            })
        }
        composable<Screens.Details> {
            ScreenDetails()
        }
    }
}
