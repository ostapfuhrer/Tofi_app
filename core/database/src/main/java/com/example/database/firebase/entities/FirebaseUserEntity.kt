package com.example.database.firebase.entities

import com.example.database.room.entities.Gender

data class FirebaseUserEntity(
    val id: String = "",
    val name: String? = null,
    val email: String? = null,
    val gender: Gender? = null,
)
