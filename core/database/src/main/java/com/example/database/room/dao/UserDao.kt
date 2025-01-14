package com.example.database.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.database.room.entities.Goal
import com.example.database.room.entities.UserEntity

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserById(id: String): UserEntity?

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Update(entity = UserEntity::class)
    suspend fun updateUser(user: UserEntity)

    @Query("Update user SET goal = :goal WHERE id = :userId")
    suspend fun updateGoal(userId: String, goal: Goal)

}