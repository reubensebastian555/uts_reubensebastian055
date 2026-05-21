package com.example.makanbro.navigation

import androidx.compose.animation.*
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.makanbro.screens.*
import com.example.makanbro.storage.PreferenceManager

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Menu : Screen("menu")
    object DetailMenu : Screen("detail_menu/{menuId}") {
        fun createRoute(menuId: Int) = "detail_menu/$menuId"
    }
    object Profile : Screen("profile")
    object EditProfile : Screen("edit_profile")
}

@Composable
fun AppNavigation(preferenceManager: PreferenceManager) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        enterTransition = { fadeIn() + slideInHorizontally() },
        exitTransition = { fadeOut() + slideOutHorizontally() }
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(onTimeout = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }

        composable(Screen.Home.route) {
            HomeScreen(
                preferenceManager = preferenceManager,
                onNavigateToMenu = { navController.navigate(Screen.Menu.route) },
                onNavigateToProfile = { navController.navigate(Screen.Profile.route) }
            )
        }

        composable(Screen.Menu.route) {
            MenuScreen(
                onNavigateToDetail = { menuId ->
                    navController.navigate(Screen.DetailMenu.createRoute(menuId))
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.DetailMenu.route,
            arguments = listOf(navArgument("menuId") { type = NavType.IntType })
        ) { backStackEntry ->
            val menuId = backStackEntry.arguments?.getInt("menuId") ?: 0
            DetailMenuScreen(
                menuId = menuId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                preferenceManager = preferenceManager,
                onNavigateToEdit = { navController.navigate(Screen.EditProfile.route) },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.EditProfile.route) {
            EditProfileScreen(
                preferenceManager = preferenceManager,
                onSaveSuccess = { navController.popBackStack() },
                onCancel = { navController.popBackStack() }
            )
        }
    }
}
