package com.example.onboarding.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.onboarding.navigation.destination.Destination
import com.example.onboarding.splash.screen.SplashScreen

fun NavGraphBuilder.splash() {
    composable(route = Destination.Splash.fullRoute) {
        SplashScreen()
    }
}
