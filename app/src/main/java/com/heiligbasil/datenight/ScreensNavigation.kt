package com.heiligbasil.datenight

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlin.reflect.typeOf

@Composable
fun ScreensNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.Home) {
        composable<Screens.Home> {
            ScreenHome(onNavigateToScreenResults = {
                navHostController.navigate(route = Screens.Results)
            })
        }
        composable<Screens.Results> {
            ScreenResults(onNavigateToScreenDetails = { searchResultPassed ->
                navHostController.navigate(route = Screens.Details(selectedDetails = searchResultPassed))
            })
        }
        composable<Screens.Details>(
            typeMap = mapOf(typeOf<SearchResult>() to SearchResultNavType)
        ) { navBackStackEntry ->
            val routeArg = navBackStackEntry.toRoute<Screens.Details>()
            ScreenDetails(searchResult = routeArg.selectedDetails)
        }
    }
}
