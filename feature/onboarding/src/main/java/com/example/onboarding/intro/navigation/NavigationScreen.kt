package com.example.onboarding.intro.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.onboarding.intro.screen.IntroScreen
import com.example.onboarding.navigation.destination.Destination

fun NavGraphBuilder.intro() {
    composable(route = Destination.Intro.fullRoute) {
        IntroScreen()
    }
}