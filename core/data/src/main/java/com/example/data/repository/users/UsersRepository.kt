package com.example.data.repository.users

import com.example.database.firebase.state.GetUserState
import com.example.database.firebase.state.LogoutState
import com.example.database.firebase.state.RegistrationState
import com.example.database.firebase.state.UpdateUserState
import com.example.database.room.entities.Goal
import com.example.database.room.entities.UserEntity

interface UsersRepository {
    suspend fun createUser(
        state: RegistrationState,
    ): RegistrationState

    suspend fun getUser(): GetUserState
    suspend fun getUser(id: String): GetUserState
    suspend fun updateUser(user: UserEntity): UpdateUserState
    suspend fun logoutUser(): LogoutState
    suspend fun deleteUserFromDB(id: String)
    suspend fun deleteUserFromCache(id: String)
    fun updateFcmToken(id: String, token: String)
    fun removeFcmToken(id: String, token: String)
    suspend fun updateGoal(userId: String, goal: Goal): UpdateUserState
}