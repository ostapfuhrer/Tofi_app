package com.example.onboarding.common.manager.toast

import android.widget.Toast

data class ToastEvent(val messageResId: Int, val duration: Int = Toast.LENGTH_SHORT)
