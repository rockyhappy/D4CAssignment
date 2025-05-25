package com.devrachit.dcasignment.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devrachit.dcasignment.presentation.screens.homescreen.HomeScreen
import com.devrachit.dcasignment.presentation.screens.homescreen.HomeViewmodel


private const val ANIMATION_DURATION = 300

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        animatedComposable(Screen.Home.route) {
            val viewmodel = hiltViewModel<HomeViewmodel>()
            val uiState = viewmodel.uiStates.collectAsStateWithLifecycle().value
            
            HomeScreen(
                uiState = uiState,
                onWishlistClick = { productName ->
                    viewmodel.addToWishlist(productName)
                },
                onCartClick = { productName ->
                    viewmodel.addToCart(productName)
                },
                onShowWishlist = {
                    viewmodel.showWishlist()
                },
                onShowCart = {
                    viewmodel.showCart()
                },
                onPerformSearch = { query, filterChipIds ->
                    viewmodel.performSearch(query, filterChipIds)
                }
            )
        }
    }
}
/**
 * Extension function for NavGraphBuilder that adds a composable with standard
 * pager-like slide animations based on navigation direction
 */
private fun NavGraphBuilder.animatedComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        arguments = arguments,
        enterTransition = { slideEnterTransition(this) },
        exitTransition = { slideExitTransition(this) },
        popEnterTransition = { slidePopEnterTransition() },
        popExitTransition = { slidePopExitTransition() }
    ) { backStackEntry ->
        // Call the content function with the NavBackStackEntry
        content(backStackEntry)
    }
}

/**
 * Creates a slide-in enter transition based on the navigation direction
 */
private fun slideEnterTransition(
    scope: AnimatedContentTransitionScope<NavBackStackEntry>
): EnterTransition {
    val targetIndex = getRouteIndex(scope.targetState.destination.route) ?: 0
    val initialIndex = getRouteIndex(scope.initialState.destination.route) ?: 0

    val direction = if (targetIndex > initialIndex)
        AnimatedContentTransitionScope.SlideDirection.Left
    else
        AnimatedContentTransitionScope.SlideDirection.Right

    return scope.slideIntoContainer(
        towards = direction,
        animationSpec = tween(ANIMATION_DURATION)
    )
}

/**
 * Creates a slide-out exit transition based on the navigation direction
 */
private fun slideExitTransition(
    scope: AnimatedContentTransitionScope<NavBackStackEntry>
): ExitTransition {
    val targetIndex = getRouteIndex(scope.targetState.destination.route) ?: 0
    val initialIndex = getRouteIndex(scope.initialState.destination.route) ?: 0

    val direction = if (targetIndex > initialIndex)
        AnimatedContentTransitionScope.SlideDirection.Left
    else
        AnimatedContentTransitionScope.SlideDirection.Right

    return scope.slideOutOfContainer(
        towards = direction,
        animationSpec = tween(ANIMATION_DURATION)
    )
}

/**
 * Creates a slide-in transition for popping the back stack (going back)
 */
private fun AnimatedContentTransitionScope<NavBackStackEntry>.slidePopEnterTransition(): EnterTransition {
    return slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(ANIMATION_DURATION)
    )
}

/**
 * Creates a slide-out transition for popping the back stack (going back)
 */
private fun AnimatedContentTransitionScope<NavBackStackEntry>.slidePopExitTransition(): ExitTransition {
    return slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(ANIMATION_DURATION)
    )
}

fun navigateToTab(navController: NavController, route: String) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    if (currentRoute != route) {
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
