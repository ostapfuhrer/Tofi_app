package com.example.data.firebase.utils

import com.example.data.R
import com.example.data.firebase.state.ChangeEmailState
import com.example.data.firebase.state.ChangePasswordState
import com.example.data.firebase.state.GetUserState
import com.example.data.firebase.state.GetUserStateDatabaseException
import com.example.data.firebase.state.GetUserStateSuccess
import com.example.data.firebase.state.LoginState
import com.example.data.firebase.state.NetworkFailure
import com.example.data.firebase.state.RegistrationNetworkFailure
import com.example.data.firebase.state.RegistrationState
import com.example.data.firebase.state.RegistrationSuccess
import com.example.data.firebase.state.RegistrationUnknownFailure
import com.example.data.firebase.state.RegistrationUserAlreadyExists
import com.example.data.firebase.state.ResetPasswordState
import com.example.data.firebase.state.ResetPasswordStateSuccess
import com.example.data.firebase.state.UnknownFailure
import com.example.data.firebase.state.UpdateUserState
import com.example.data.firebase.state.UpdateUserStateDatabaseException
import com.example.data.firebase.state.UpdateUserStateNetworkFailure
import com.example.data.firebase.state.UpdateUserStateSuccess
import com.example.data.firebase.state.UpdateUserStateUnknownFailure
import com.example.data.firebase.state.UserIsNotExists

fun RegistrationState.toMessageId(): Int = when (this) {
    is RegistrationUserAlreadyExists -> R.string.user_with_this_email_already_exists
    is RegistrationNetworkFailure -> R.string.no_internet_connection
    is RegistrationUnknownFailure -> R.string.unknown_error_has_occurred
    is RegistrationSuccess -> R.string.registration_success
}

fun LoginState.toMessageId(): Int? = when (this) {
    is LoginState.InvalidCredentials -> R.string.invalid_login_credentials
    is LoginState.NetworkFailure -> R.string.no_internet_connection
    is LoginState.UnknownFailure -> R.string.unknown_error_has_occurred
    is LoginState.Success -> null
}

fun ResetPasswordState.toMessageId(): Int = when (this) {
    is UserIsNotExists -> R.string.user_is_not_exists_message
    is NetworkFailure -> R.string.no_internet_connection
    is UnknownFailure -> R.string.unknown_error_has_occurred
    is ResetPasswordStateSuccess -> R.string.reset_password_message
}

fun GetUserState.toMessageId(): Int? = when (this) {
    is GetUserStateSuccess -> null
    is GetUserStateDatabaseException -> R.string.try_later
    else -> R.string.unknown_error_has_occurred
}

fun ChangePasswordState.toMessageId(): Int = when (this) {
    is ChangePasswordState.UserIsNotExists -> R.string.user_is_not_exists_message
    is ChangePasswordState.InvalidCredentials -> R.string.invalid_login_password
    is ChangePasswordState.ChangePasswordSuccess -> R.string.change_password_success
    is ChangePasswordState.NetworkFailure -> R.string.no_internet_connection
    else -> R.string.unknown_error_has_occurred
}

fun ChangeEmailState.toMessageId(): Int? = when (this) {
    is ChangeEmailState.Success -> null
    is ChangeEmailState.UserIsNotExists -> R.string.user_is_not_exists_message
    is ChangeEmailState.EmailAlreadyTaken -> R.string.user_with_this_email_already_exists
    is ChangeEmailState.InvalidCredentials -> R.string.invalid_login_password
    is ChangeEmailState.NetworkFailure -> R.string.no_internet_connection
    is ChangeEmailState.UnknownFailure -> R.string.unknown_error_has_occurred
}

fun UpdateUserState.toMessageId(): Int? = when (this) {
    is UpdateUserStateSuccess -> null
    is UpdateUserStateNetworkFailure -> R.string.no_internet_connection
    is UpdateUserStateDatabaseException -> R.string.try_later
    is UpdateUserStateUnknownFailure -> R.string.unknown_error_has_occurred
    else -> R.string.unknown_error_has_occurred
}

