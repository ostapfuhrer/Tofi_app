package com.example.tofi_app.navigation.actions

import com.example.onboarding.intro.navigation.IntroNavigationActions
import com.example.onboarding.navigation.destination.OnboardingDestination
import com.example.tofi_app.navigation.navigator.AppNavigator
import javax.inject.Inject

class IntroNavigationActionsImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : IntroNavigationActions {
    override suspend fun navigateToGoal() {
        appNavigator.navigateTo(
            route = OnboardingDestination.Goal.route,
            popUpToRoute = OnboardingDestination.Intro.route,
            inclusive = true,
            isSingleTop = true
        )
    }

    override suspend fun navigateToLogin() {
        appNavigator.navigateTo(
            route = OnboardingDestination.Login.route,
            popUpToRoute = OnboardingDestination.Intro.route,
            inclusive = true,
            isSingleTop = true
        )
    }
}