package com.example.database.firebase.state

sealed interface LogoutState {

    object LogoutSuccess : LogoutState

    object LogoutFailure : LogoutState

}