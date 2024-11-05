package com.example.data.firebase.auth

import com.example.data.firebase.state.ChangeEmailState
import com.example.data.firebase.state.ChangePasswordState
import com.example.data.firebase.state.LoginState
import com.example.data.firebase.state.LogoutState
import com.example.data.firebase.state.ReauthState
import com.example.data.firebase.state.RegistrationState
import com.example.data.firebase.state.ReloadState
import com.example.data.firebase.state.ResetPasswordState
import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthAPI {
    suspend fun register(email: String, password: String): RegistrationState
    suspend fun login(email: String, password: String): LoginState
    suspend fun resetPassword(email: String): ResetPasswordState
    suspend fun changePassword(newPassword: String): ChangePasswordState
    suspend fun changeEmail(newEmail: String,currentPassword: String): ChangeEmailState
    suspend fun reauthenticate(currentPassword: String): ReauthState
    suspend fun reload(): ReloadState
    fun isUserLoggedIn(): Boolean
    fun currentUser(): FirebaseUser?
    fun currentUserId(): String?
    suspend fun logoutUser(): LogoutState
}