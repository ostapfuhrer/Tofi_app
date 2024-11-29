package com.example.onboarding.navigation.actions

import com.example.onboarding.intro.navigation.IntroNavigationActions
import com.example.onboarding.navigation.destination.Destination
import com.example.onboarding.navigation.navigator.AppNavigator
import javax.inject.Inject

class IntroNavigationActionsImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : IntroNavigationActions {
    override suspend fun navigateToGoal() {
        appNavigator.navigateTo(
            route = Destination.Goal.route,
            popUpToRoute = Destination.Intro.route,
            inclusive = true,
            isSingleTop = true
        )
    }

    override suspend fun navigateToLogin() {
        appNavigator.navigateTo(
            route = Destination.Login.route,
            popUpToRoute = Destination.Intro.route,
            inclusive = true,
            isSingleTop = true
        )
    }
}