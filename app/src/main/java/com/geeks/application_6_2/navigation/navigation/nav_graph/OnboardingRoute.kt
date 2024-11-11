package com.geeks.application_6_2.navigation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.NavHostController
import com.geeks.application_6_2.navigation.ui.ui.screen.ConfirmationScreen
import com.geeks.application_6_2.navigation.ui.ui.screen.RegistrationScreen
import com.geeks.application_6_2.navigation.ui.ui.screen.WelcomeScreen


sealed class OnboardingScreen(val route: String) {

    data object Welcome : OnboardingScreen("welcome")

    data object Registration : OnboardingScreen("registration")

    data object Confirmation : OnboardingScreen("confirmation/{userName}") {

        fun createRoute(userName: String) = "confirmation/$userName"
    }
}

@Composable

fun OnboardingNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = OnboardingScreen.Welcome.route) {
        composable(OnboardingScreen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(OnboardingScreen.Registration.route) {
            RegistrationScreen(navController)
        }
        composable(
            OnboardingScreen.Confirmation.route,
            arguments = listOf(navArgument("userName") { type = NavType.StringType })
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName")
            ConfirmationScreen(userName = userName ?: "")
        }
    }
}
