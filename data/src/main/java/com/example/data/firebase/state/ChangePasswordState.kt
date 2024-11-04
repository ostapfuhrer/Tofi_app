package com.example.data.firebase.state

sealed class ChangePasswordState {

    object ChangePasswordSuccess : ChangePasswordState()

    object UserIsNotExists : ChangePasswordState()

    object InvalidCredentials : ChangePasswordState()

    object NetworkFailure : ChangePasswordState()

    object UnknownFailure : ChangePasswordState()

}

