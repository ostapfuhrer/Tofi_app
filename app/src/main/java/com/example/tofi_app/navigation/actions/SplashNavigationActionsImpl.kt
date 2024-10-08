package com.example.tofi_app.navigation.actions

import com.example.tofi_app.navigation.destination.Destination
import com.example.tofi_app.navigation.navigator.AppNavigator
import com.example.tofi_app.splash.navigation.SplashNavigationActions
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