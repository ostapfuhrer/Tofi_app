package com.example.onboarding.navigation.destination

sealed class OnboardingDestination(val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{$it}") }
        builder.toString()
    }

    protected fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    object Splash : OnboardingDestination("splash")
    object Intro : OnboardingDestination("intro")
    object Goal : OnboardingDestination("goal")
    object Login : OnboardingDestination("login")
}