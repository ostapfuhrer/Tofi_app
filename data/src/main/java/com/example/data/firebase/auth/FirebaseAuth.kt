package com.example.data.firebase.auth

import com.example.data.firebase.auth.handlers.AuthErrorHandler
import com.example.data.firebase.state.ChangeEmailState
import com.example.data.firebase.state.ChangePasswordState
import com.example.data.firebase.state.LoginState
import com.example.data.firebase.state.LogoutState
import com.example.data.firebase.state.ReauthState
import com.example.data.firebase.state.RegistrationState
import com.example.data.firebase.state.RegistrationSuccess
import com.example.data.firebase.state.RegistrationUnknownFailure
import com.example.data.firebase.state.ReloadState
import com.example.data.firebase.state.ReloadStateError
import com.example.data.firebase.state.ReloadStateFailure
import com.example.data.firebase.state.ReloadStateSuccess
import com.example.data.firebase.state.ResetPasswordState
import com.example.data.firebase.state.ResetPasswordStateSuccess
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FirebaseAuth @Inject constructor(
    private val authErrorHandler: AuthErrorHandler
) : FirebaseAuthAPI {

    private val firebaseAuth = FirebaseAuth.getInstance()

    override suspend fun register(email: String, password: String): RegistrationState {
        return suspendCoroutine { continuation ->
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userId = task.result?.user?.uid
                        continuation.resume(userId?.let { RegistrationSuccess(userId = it) }
                            ?: RegistrationUnknownFailure)
                    } else {
                        continuation.resume(authErrorHandler.handleRegistrationException(task.exception))
                    }
                }
        }
    }

    override suspend fun login(email: String, password: String): LoginState {
        return suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                continuation.resume(
                    if (task.isSuccessful) LoginState.Success
                    else authErrorHandler.handleLoginException(task.exception)
                )
            }
        }
    }

    override suspend fun resetPassword(email: String): ResetPasswordState {
        return suspendCoroutine { continuation ->
            firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    continuation.resume(
                        if (task.isSuccessful) ResetPasswordStateSuccess
                        else authErrorHandler.handleResetPasswordException(task.exception)
                    )
                }
        }
    }

    override suspend fun changePassword(newPassword: String): ChangePasswordState {
        return suspendCoroutine { continuation ->
            currentUser()?.updatePassword(newPassword)?.addOnCompleteListener { task ->
                continuation.resume(
                    if (task.isSuccessful) ChangePasswordState.ChangePasswordSuccess
                    else authErrorHandler.handleChangePasswordException(task.exception)
                )
            } ?: continuation.resume(ChangePasswordState.UnknownFailure)
        }
    }

    override suspend fun changeEmail(newEmail: String, currentPassword: String): ChangeEmailState {
        return suspendCoroutine { continuation ->
            val user = currentUser()
            if (user != null) {
                val credential =
                    user.email?.let { EmailAuthProvider.getCredential(it, currentPassword) }

                if (credential != null) {
                    user.reauthenticate(credential).addOnCompleteListener { reauthTask ->
                        if (reauthTask.isSuccessful) {
                            user.verifyBeforeUpdateEmail(newEmail).addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    continuation.resume(ChangeEmailState.Success)
                                } else {
                                    continuation.resume(
                                        authErrorHandler.handleChangeEmailException(
                                            task.exception
                                        )
                                    )
                                }
                            }
                        } else {
                            val reauthState =
                                authErrorHandler.handleReauthException(reauthTask.exception)
                            continuation.resume(
                                when (reauthState) {
                                    is ReauthState.InvalidCredentials -> ChangeEmailState.InvalidCredentials
                                    is ReauthState.UserIsNotExist -> ChangeEmailState.UserIsNotExists
                                    is ReauthState.NetworkFailure -> ChangeEmailState.NetworkFailure
                                    else -> ChangeEmailState.UnknownFailure
                                }
                            )
                        }
                    }
                } else {
                    continuation.resume(ChangeEmailState.InvalidCredentials)
                }
            } else {
                continuation.resume(ChangeEmailState.UserIsNotExists)
            }
        }
    }

    override suspend fun reauthenticate(currentPassword: String): ReauthState {
        return suspendCoroutine { continuation ->
            val credential =
                EmailAuthProvider.getCredential(currentUser()?.email!!, currentPassword)
            currentUser()?.reauthenticate(credential)?.addOnCompleteListener { task ->
                continuation.resume(
                    if (task.isSuccessful) ReauthState.ReauthStateSuccess
                    else authErrorHandler.handleReauthException(task.exception)
                )
            } ?: continuation.resume(ReauthState.UnknownFailure)
        }
    }

    override fun isUserLoggedIn(): Boolean = currentUser() != null

    override suspend fun reload(): ReloadState {
        return suspendCoroutine { continuation ->
            currentUser()?.reload()?.addOnCompleteListener { task ->
                continuation.resume(
                    if (task.isSuccessful) ReloadStateSuccess
                    else authErrorHandler.handleReloadException(task.exception)
                )
            } ?: continuation.resume(ReloadStateFailure(ReloadStateError.UnknownFailure))
        }
    }

    override fun currentUser(): FirebaseUser? = firebaseAuth.currentUser

    override fun currentUserId(): String? = currentUser()?.uid

    override suspend fun logoutUser(): LogoutState {
        return suspendCoroutine { continuation ->
            try {
                firebaseAuth.signOut()
                continuation.resume(LogoutState.LogoutSuccess)
            } catch (exception: Exception) {
                continuation.resume(LogoutState.LogoutFailure)
            }
        }
    }
}