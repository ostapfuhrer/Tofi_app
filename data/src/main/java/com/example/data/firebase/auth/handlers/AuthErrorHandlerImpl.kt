package com.example.data.firebase.auth.handlers

import com.example.data.firebase.state.ChangeEmailState
import com.example.data.firebase.state.ChangePasswordState
import com.example.data.firebase.state.LoginState
import com.example.data.firebase.state.NetworkFailure
import com.example.data.firebase.state.ReauthState
import com.example.data.firebase.state.RegistrationNetworkFailure
import com.example.data.firebase.state.RegistrationState
import com.example.data.firebase.state.RegistrationUnknownFailure
import com.example.data.firebase.state.RegistrationUserAlreadyExists
import com.example.data.firebase.state.ReloadState
import com.example.data.firebase.state.ReloadStateError
import com.example.data.firebase.state.ReloadStateFailure
import com.example.data.firebase.state.ResetPasswordState
import com.example.data.firebase.state.UnknownFailure
import com.example.data.firebase.state.UserIsNotExists
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import javax.inject.Inject

class AuthErrorHandlerImpl @Inject constructor() : AuthErrorHandler {
    override fun handleRegistrationException(exception: Exception?): RegistrationState {
        return when (exception) {
            is FirebaseNetworkException -> RegistrationNetworkFailure
            is FirebaseAuthUserCollisionException -> RegistrationUserAlreadyExists
            else -> RegistrationUnknownFailure
        }
    }

    override fun handleLoginException(exception: Exception?): LoginState {
        return when (exception) {
            is FirebaseAuthInvalidUserException, is FirebaseAuthInvalidCredentialsException -> LoginState.InvalidCredentials
            is FirebaseNetworkException -> LoginState.NetworkFailure
            else -> LoginState.UnknownFailure
        }
    }

    override fun handleResetPasswordException(exception: Exception?): ResetPasswordState {
        return when (exception) {
            is FirebaseAuthInvalidUserException -> UserIsNotExists
            is FirebaseNetworkException -> NetworkFailure
            else -> UnknownFailure
        }
    }

    override fun handleChangePasswordException(exception: Exception?): ChangePasswordState {
        return when (exception) {
            is FirebaseNetworkException -> ChangePasswordState.NetworkFailure
            else -> ChangePasswordState.UnknownFailure
        }
    }

    override fun handleChangeEmailException(exception: Exception?): ChangeEmailState {
        return when (exception) {
            is FirebaseNetworkException -> ChangeEmailState.NetworkFailure
            is FirebaseAuthUserCollisionException -> ChangeEmailState.EmailAlreadyTaken
            else -> ChangeEmailState.UnknownFailure
        }
    }

    override fun handleReauthException(exception: Exception?): ReauthState {
        return when (exception) {
            is FirebaseNetworkException -> ReauthState.NetworkFailure
            is FirebaseAuthInvalidUserException -> ReauthState.UserIsNotExist
            is FirebaseAuthInvalidCredentialsException -> ReauthState.InvalidCredentials
            else -> ReauthState.UnknownFailure
        }
    }

    override fun handleReloadException(exception: Exception?): ReloadState {
        return when (exception) {
            is FirebaseAuthInvalidUserException -> ReloadStateFailure(ReloadStateError.AuthInvalidUserException)
            else -> ReloadStateFailure(ReloadStateError.UnknownFailure)
        }
    }
}