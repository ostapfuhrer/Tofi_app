package com.example.onboarding.intro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onboarding.common.manager.toast.ToastManager
import com.example.onboarding.intro.event.IntroEvent
import com.example.onboarding.intro.navigation.IntroNavigationActions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val navigationActions: IntroNavigationActions,
    private val toastManager: ToastManager,
) : ViewModel() {

    fun onEvent(event: IntroEvent) {
        when (event) {
            is IntroEvent.NavigateToGoal -> navigateToGoal()
            is IntroEvent.NavigateToLogin -> navigateToLogin()
        }
    }

    private fun navigateToGoal() {
        viewModelScope.launch {
            navigationActions.navigateToGoal()
        }
    }

    private fun navigateToLogin() {
        viewModelScope.launch {
            navigationActions.navigateToLogin()
        }
    }

}