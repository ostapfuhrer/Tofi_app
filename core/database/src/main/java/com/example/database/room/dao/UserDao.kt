package com.example.database.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.room.entities.UserEntity

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = id")
    suspend fun getUserById(id: String): UserEntity?

    @Delete
    suspend fun deleteUser(user: UserEntity)
}