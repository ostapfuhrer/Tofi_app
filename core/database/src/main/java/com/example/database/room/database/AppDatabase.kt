package com.example.database.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.room.dao.UserDao
import com.example.database.room.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}