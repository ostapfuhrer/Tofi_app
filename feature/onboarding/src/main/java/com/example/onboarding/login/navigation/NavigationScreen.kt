package com.example.onboarding.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.onboarding.login.screens.LoginScreen
import com.example.onboarding.navigation.destination.Destination

fun NavGraphBuilder.login() {
    composable(route = Destination.Login.fullRoute) {
        LoginScreen()
    }
}