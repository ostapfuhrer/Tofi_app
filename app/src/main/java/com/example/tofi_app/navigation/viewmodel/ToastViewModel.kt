package com.example.tofi_app.navigation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tofi_app.common.manager.toast.ToastManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToastViewModel @Inject constructor(
    val toastManager: ToastManager
) : ViewModel() {

    val toastFlow = toastManager.toastFlow
}