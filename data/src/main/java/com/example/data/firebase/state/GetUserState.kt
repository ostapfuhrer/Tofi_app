package com.example.data.firebase.state

import com.example.data.room.entities.UserEntity

sealed class GetUserState

data class GetUserStateSuccess(val user: UserEntity) : GetUserState()

object GetUserStateDatabaseException : GetUserState()

object GetUserStateRoomNotFound : GetUserState()
object GetUserStateUserNotFound : GetUserState()

object GetUserStateUnknownFailure : GetUserState()