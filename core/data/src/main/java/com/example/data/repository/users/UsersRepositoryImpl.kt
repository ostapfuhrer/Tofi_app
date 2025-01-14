package com.example.data.repository.users

import com.example.database.firebase.auth.FirebaseAuthAPI
import com.example.database.firebase.connection.FirebaseConnection
import com.example.database.firebase.database.users.FirebaseUsersDataSource
import com.example.database.firebase.state.GetUserState
import com.example.database.firebase.state.GetUserStateRoomNotFound
import com.example.database.firebase.state.GetUserStateSuccess
import com.example.database.firebase.state.GetUserStateUserNotFound
import com.example.database.firebase.state.LogoutState
import com.example.database.firebase.state.RegistrationState
import com.example.database.firebase.state.UpdateUserState
import com.example.database.room.dao.UserDao
import com.example.database.room.entities.Goal
import com.example.database.room.entities.UserEntity
import java.util.Collections
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val firebaseUsersDataSource: FirebaseUsersDataSource,
    private val userDao: UserDao,
    private val firebaseAuth: FirebaseAuthAPI,
    private val firebaseConnection: FirebaseConnection,
) : UsersRepository {

    companion object {
        private val cachedUsers: MutableList<UserEntity> =
            Collections.synchronizedList(mutableListOf())
    }

    override suspend fun createUser(state: RegistrationState): RegistrationState {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): GetUserState {
        val currentUserId = firebaseAuth.currentUserId()
            ?: return GetUserStateUserNotFound
        return getUser(currentUserId)
    }

    override suspend fun getUser(id: String): GetUserState {
        val cachedUser = cachedUsers.find { it.id == id }
        return when {
            cachedUser != null -> {
                GetUserStateSuccess(cachedUser)
            }

            !firebaseConnection.getConnection() -> {
                val userInRoom = userDao.getUserById(id)
                if (userInRoom != null) {
                    GetUserStateSuccess(userInRoom)
                } else {
                    GetUserStateRoomNotFound
                }
            }

            else -> {
                val getUserStateFromFirebase =
                    firebaseUsersDataSource.getUserFromFirebase(id)
                return if (getUserStateFromFirebase is GetUserStateSuccess) {
                    addUserInCache(getUserStateFromFirebase.user)
                    addUserInRoom(getUserStateFromFirebase.user)
                    GetUserStateSuccess(getUserStateFromFirebase.user)
                } else {
                    getUserStateFromFirebase
                }
            }
        }
    }

    private fun addUserInCache(newUser: UserEntity) {

        val cachedUser = cachedUsers.find { it.id == newUser.id }
        if (cachedUser == null) {
            cachedUsers.add(newUser)
        } else {
            cachedUsers.remove(cachedUser)
            cachedUsers.add(newUser)
        }
    }

    private suspend fun addUserInRoom(userEntity: UserEntity) = userDao.insertUser(userEntity)

    override suspend fun updateUser(user: UserEntity): UpdateUserState {
        TODO("Not yet implemented")
    }

    override suspend fun logoutUser(): LogoutState {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUserFromDB(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUserFromCache(id: String) {
        TODO("Not yet implemented")
    }

    override fun updateFcmToken(id: String, token: String) {
        TODO("Not yet implemented")
    }

    override fun removeFcmToken(id: String, token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateGoal(userId: String, goal: Goal): UpdateUserState {
        TODO("Not yet implemented")
    }

    private suspend fun updateUserInRoom(user: UserEntity) = userDao.updateUser(user)

    private suspend fun updateGoalInRoom(userId: String, goal: Goal) =
        userDao.updateGoal(userId = userId, goal = goal)

}