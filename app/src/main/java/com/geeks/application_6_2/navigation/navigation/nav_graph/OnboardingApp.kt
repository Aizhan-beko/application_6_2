package com.geeks.application_6_2.navigation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun OnboardingApp() {
    val navController = rememberNavController()
    OnboardingNavGraph(navController)
}