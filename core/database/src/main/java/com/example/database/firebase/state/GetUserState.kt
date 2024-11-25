package com.example.database.firebase.state

import com.example.database.room.entities.UserEntity

sealed class GetUserState

data class GetUserStateSuccess(val user: UserEntity) : GetUserState()

object GetUserStateDatabaseException : GetUserState()

object GetUserStateRoomNotFound : GetUserState()
object GetUserStateUserNotFound : GetUserState()

object GetUserStateUnknownFailure : GetUserState()