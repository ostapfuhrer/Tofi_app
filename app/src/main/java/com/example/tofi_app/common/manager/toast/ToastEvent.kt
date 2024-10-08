package com.example.tofi_app.common.manager.toast

import android.widget.Toast

data class ToastEvent(val messageResId: Int, val duration: Int = Toast.LENGTH_SHORT)
