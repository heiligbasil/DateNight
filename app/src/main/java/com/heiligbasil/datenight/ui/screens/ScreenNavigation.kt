package com.heiligbasil.datenight.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.heiligbasil.datenight.MainViewModel
import com.heiligbasil.datenight.MainViewModelFactory
import com.heiligbasil.datenight.data.CustomSearchRepositoryImpl
import com.heiligbasil.datenight.data.RetrofitInstance
import com.heiligbasil.datenight.ui.entities.SearchResult
import com.heiligbasil.datenight.ui.entities.SearchResult.Companion.SearchResultNavType
import kotlinx.coroutines.launch
import kotlin.reflect.typeOf

@Composable
fun ScreenNavigation(navHostController: NavHostController) {
    val animationDuration = 1000
    val mainViewModel = LocalViewModelStoreOwner.current?.let { viewModelStoreOwner ->
        viewModel(
            viewModelStoreOwner = viewModelStoreOwner,
            key = MainViewModel::class.java.simpleName,
            factory = MainViewModelFactory(CustomSearchRepositoryImpl(RetrofitInstance.api))
        )
    } ?: run {
        MainViewModel(customSearchRepository = CustomSearchRepositoryImpl(RetrofitInstance.api))
    }
    NavHost(
        navController = navHostController, startDestination = Screens.Home,
        enterTransition = {
            fadeIn(
                animationSpec = tween(
                    durationMillis = animationDuration,
                    easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(durationMillis = animationDuration, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        }, exitTransition = {
            fadeOut(
                animationSpec = tween(
                    durationMillis = animationDuration, easing = LinearEasing
                )
            ) + slideOutOfContainer(
                animationSpec = tween(durationMillis = animationDuration, easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.End
            )
        }
    ) {
        composable<Screens.Home> {
            val coroutineScope = rememberCoroutineScope()
            ScreenHome(onNavigateToScreenResults = { searchQueryPassed ->
                coroutineScope.launch {
                    mainViewModel.getCustomSearchResults(searchQuery = searchQueryPassed)
                    mainViewModel.convertCustomSearchResponseToSearchResultList()
                    navHostController.navigate(route = Screens.Results)
                }
            })
        }
        composable<Screens.Results> {
            ScreenResults(
                searchResults = mainViewModel.searchResults,
                onNavigateToScreenDetails = { searchResultPassed ->
                    navHostController.navigate(route = Screens.Details(selectedDetails = searchResultPassed))
                })
        }
        composable<Screens.Details>(typeMap = mapOf(typeOf<SearchResult>() to SearchResultNavType))
        { navBackStackEntry ->
            val routeArg = navBackStackEntry.toRoute<Screens.Details>()
            ScreenDetails(searchResult = routeArg.selectedDetails)
        }
    }
}
