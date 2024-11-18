package com.example.data.firebase.auth.exceptions

import com.example.database.firebase.state.ChangeEmailState
import com.example.database.firebase.state.ChangePasswordState
import com.example.database.firebase.state.LoginState
import com.example.database.firebase.state.ReauthState
import com.example.database.firebase.state.RegistrationState
import com.example.database.firebase.state.ReloadState
import com.example.database.firebase.state.ResetPasswordState

 interface ExceptionAuth {
    fun handleRegistrationException(exception: Exception?): RegistrationState
    fun handleLoginException(exception: Exception?): LoginState
    fun handleResetPasswordException(exception: Exception?): ResetPasswordState
    fun handleChangePasswordException(exception: Exception?): ChangePasswordState
    fun handleChangeEmailException(exception: Exception?): ChangeEmailState
    fun handleReauthException(exception: Exception?): ReauthState
    fun handleReloadException(exception: Exception?): ReloadState
}