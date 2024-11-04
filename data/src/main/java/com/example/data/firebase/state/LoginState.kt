package com.example.data.firebase.state

sealed interface LoginState {
    object Success : LoginState
    object InvalidCredentials : LoginState
    object NetworkFailure : LoginState
    object UnknownFailure : LoginState
}