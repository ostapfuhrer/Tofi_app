package com.example.database.firebase.auth.exceptions

import com.example.data.firebase.auth.exceptions.ExceptionAuth
import com.example.database.firebase.state.ChangeEmailState
import com.example.database.firebase.state.ChangePasswordState
import com.example.database.firebase.state.LoginState
import com.example.database.firebase.state.NetworkFailure
import com.example.database.firebase.state.ReauthState
import com.example.database.firebase.state.RegistrationNetworkFailure
import com.example.database.firebase.state.RegistrationState
import com.example.database.firebase.state.RegistrationUnknownFailure
import com.example.database.firebase.state.RegistrationUserAlreadyExists
import com.example.database.firebase.state.ReloadState
import com.example.database.firebase.state.ReloadStateError
import com.example.database.firebase.state.ReloadStateFailure
import com.example.database.firebase.state.ResetPasswordState
import com.example.database.firebase.state.UnknownFailure
import com.example.database.firebase.state.UserIsNotExists
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import javax.inject.Inject

class ExceptionAuthMapper @Inject constructor() : ExceptionAuth {
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