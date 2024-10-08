package com.example.tofi_app.navigation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tofi_app.navigation.navigator.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    appNavigator: AppNavigator
) : ViewModel() {
    val navigationFlow = appNavigator.navigationFlow
}