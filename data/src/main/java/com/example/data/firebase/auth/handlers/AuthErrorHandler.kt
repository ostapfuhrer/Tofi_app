package com.example.data.firebase.auth.handlers

import com.example.data.firebase.state.ChangeEmailState
import com.example.data.firebase.state.ChangePasswordState
import com.example.data.firebase.state.LoginState
import com.example.data.firebase.state.ReauthState
import com.example.data.firebase.state.RegistrationState
import com.example.data.firebase.state.ReloadState
import com.example.data.firebase.state.ResetPasswordState

 interface AuthErrorHandler {
    fun handleRegistrationException(exception: Exception?): RegistrationState
    fun handleLoginException(exception: Exception?): LoginState
    fun handleResetPasswordException(exception: Exception?): ResetPasswordState
    fun handleChangePasswordException(exception: Exception?): ChangePasswordState
    fun handleChangeEmailException(exception: Exception?): ChangeEmailState
    fun handleReauthException(exception: Exception?): ReauthState
    fun handleReloadException(exception: Exception?): ReloadState
}