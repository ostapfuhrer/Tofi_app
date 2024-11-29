package com.example.onboarding.intro.event

sealed interface IntroEvent {
    object NavigateToGoal : IntroEvent
    object NavigateToLogin : IntroEvent
}