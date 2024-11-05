package com.example.data.firebase.state

sealed interface LogoutState {

    object LogoutSuccess : LogoutState

    object LogoutFailure : LogoutState

}