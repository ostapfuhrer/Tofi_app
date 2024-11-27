package com.example.onboarding.splash.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.firebase.auth.FirebaseAuthAPI
import com.example.database.firebase.connection.FirebaseConnection
import com.example.database.firebase.state.ReloadStateFailure
import com.example.database.firebase.state.ReloadStateSuccess
import com.example.onboarding.common.manager.toast.ToastEvent
import com.example.onboarding.common.manager.toast.ToastManager
import com.example.onboarding.splash.navigation.SplashNavigationActions
import com.example.onboarding.splash.utils.errorToastId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val navigationActions: SplashNavigationActions,
    private val toastManager: ToastManager,
    private val firebaseConnection: FirebaseConnection,
    private val firebaseAuth: FirebaseAuthAPI
) : ViewModel() {

    init {
        checkConnection()
    }

    private fun checkConnection() {
        viewModelScope.launch(Dispatchers.Default) {
            if (firebaseConnection.waitConnection()) {
                checkUserLoggedIn()
            } else {
                toastManager.sendToast(ToastEvent(errorToastId, Toast.LENGTH_SHORT))
            }
        }
    }

    private fun checkUserLoggedIn() {
        viewModelScope.launch(Dispatchers.Default) {
            val isUserLoggedIn = firebaseAuth.isUserLoggedIn()
            if (!isUserLoggedIn) {
                navigateToIntro()
            } else {
                when (firebaseAuth.reload()) {
                    is ReloadStateSuccess -> {/*TODO navigate to Main.*/
                    }

                    is ReloadStateFailure -> navigateToIntro()
                }
            }
        }
    }

    private fun navigateToIntro() {
        viewModelScope.launch {
            navigationActions.navigateToIntro()
        }
    }
}