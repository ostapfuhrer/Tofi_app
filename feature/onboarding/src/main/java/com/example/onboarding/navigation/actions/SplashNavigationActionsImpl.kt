package com.example.onboarding.navigation.actions

import com.example.onboarding.navigation.destination.Destination
import com.example.onboarding.navigation.navigator.AppNavigator
import com.example.onboarding.splash.navigation.SplashNavigationActions
import javax.inject.Inject

class SplashNavigationActionsImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : SplashNavigationActions {
    override suspend fun navigateToIntro() {
        appNavigator.navigateTo(
            route = Destination.IntroScreen.route,
            popUpToRoute = Destination.SplashScreen.route,
            inclusive = true,
            isSingleTop = true
        )
    }
}