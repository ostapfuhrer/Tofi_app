package com.example.tofi_app.navigation.actions

import com.example.onboarding.navigation.destination.OnboardingDestination
import com.example.onboarding.splash.navigation.SplashNavigationActions
import com.example.tofi_app.navigation.navigator.AppNavigator
import javax.inject.Inject

class SplashNavigationActionsImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : SplashNavigationActions {
    override suspend fun navigateToIntro() {
        appNavigator.navigateTo(
            route = OnboardingDestination.Intro.route,
            popUpToRoute = OnboardingDestination.Splash.route,
            inclusive = true,
            isSingleTop = true
        )
    }
}