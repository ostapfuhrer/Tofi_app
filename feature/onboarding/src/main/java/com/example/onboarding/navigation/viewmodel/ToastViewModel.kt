package com.example.onboarding.navigation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.onboarding.common.manager.toast.ToastManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToastViewModel @Inject constructor(
    val toastManager: ToastManager
) : ViewModel() {

    val toastFlow = toastManager.toastFlow
}