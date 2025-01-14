package com.example.database.firebase.database.users

import com.example.database.firebase.entities.FirebaseUserEntity
import com.example.database.firebase.state.GetUserState
import com.example.database.firebase.state.RegistrationState
import com.example.database.firebase.state.RegistrationSuccess
import com.example.database.firebase.state.RegistrationUnknownFailure
import com.example.database.firebase.state.UpdateUserState
import com.example.database.firebase.utils.DbConstant.USERS_TABLE
import com.example.database.room.entities.UserEntity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FirebaseUsersDataSourceImpl @Inject constructor() : FirebaseUsersDataSource {

    private val database = Firebase.database.reference
    private val storage = FirebaseStorage.getInstance().reference
    private val usersTable = database.child(USERS_TABLE)

    override suspend fun createUserInFirebaseDB(
        id: String,
        name: String,
        email: String
    ): RegistrationState {
        return suspendCoroutine { continuation ->
            val firebaseUser = FirebaseUserEntity(
                id = id,
                name = name,
                email = email,
            )
            val callback = OnCompleteListener<Void> { task ->
                if (task.isSuccessful) {
                    continuation.resume(RegistrationSuccess(id))
                } else {
                    continuation.resume(RegistrationUnknownFailure)
                }
            }
            usersTable.child(id).setValue(firebaseUser).addOnCompleteListener(callback)
        }
    }

    override suspend fun getUserFromFirebase(id: String): GetUserState {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserInFirebaseDB(user: UserEntity): UpdateUserState {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUserData(id: String): UpdateUserState {
        TODO("Not yet implemented")
    }
}