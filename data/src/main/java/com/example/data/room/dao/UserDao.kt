package com.example.data.room.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.room.entities.UserEntity

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

  //  @Query("SELECT * FROM users WHERE id = :id")
  //  suspend fun getUserById(id: String): UserEntity?
//
  //  @Query("DELETE FROM users")
  //  suspend fun deleteAllUsers()
}