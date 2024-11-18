package com.example.database.firebase.state

sealed class ResetPasswordState

object ResetPasswordStateSuccess : ResetPasswordState()

object NetworkFailure : ResetPasswordState()

object UserIsNotExists : ResetPasswordState()

object UnknownFailure : ResetPasswordState()