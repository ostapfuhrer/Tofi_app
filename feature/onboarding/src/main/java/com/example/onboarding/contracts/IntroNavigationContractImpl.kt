package com.example.onboarding.contracts

import com.example.onboarding.navigation.destination.OnboardingDestination
import javax.inject.Inject

class IntroNavigationContractImpl @Inject constructor() : IntroNavigationContract {
    override fun navigateToGoal(): String {
        return OnboardingDestination.Goal.route
    }

    override fun navigateToLogin(): String {
        return OnboardingDestination.Login.route
    }
}