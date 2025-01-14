package com.example.database.firebase.database.users

import com.example.database.firebase.state.GetUserState
import com.example.database.firebase.state.RegistrationState
import com.example.database.firebase.state.UpdateUserState
import com.example.database.room.entities.UserEntity

interface FirebaseUsersDataSource {
    suspend fun createUserInFirebaseDB(id: String, name: String, email: String): RegistrationState
    suspend fun getUserFromFirebase(id: String): GetUserState
    suspend fun updateUserInFirebaseDB(user: UserEntity): UpdateUserState
    suspend fun deleteUserData(id: String): UpdateUserState
}