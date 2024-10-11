package com.example.tofi_app.splash_screen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tofi_app.navigation.destination.Destination
import com.example.tofi_app.splash_screen.screen.SplashScreen

fun NavGraphBuilder.splashScreen() {
    composable(route = Destination.SplashScreen.fullRoute) {
        SplashScreen()
    }
}
