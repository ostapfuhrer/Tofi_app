package com.example.onboarding.goal.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.onboarding.goal.screen.GoalScreen
import com.example.onboarding.navigation.destination.OnboardingDestination

fun NavGraphBuilder.goal() {
    composable(route = OnboardingDestination.Goal.fullRoute) {
        GoalScreen()
    }
}