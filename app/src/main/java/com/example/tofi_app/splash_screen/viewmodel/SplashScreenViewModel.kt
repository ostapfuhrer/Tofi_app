package com.example.tofi_app.splash_screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tofi_app.splash_screen.navigation.SplashNavigationActions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val navigationActions: SplashNavigationActions,
    // private val toastManager: ToastManager,
) : ViewModel() {
}