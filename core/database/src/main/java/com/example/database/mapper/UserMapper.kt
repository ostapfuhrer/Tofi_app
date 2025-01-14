package com.example.database.mapper

import com.example.database.firebase.entities.FirebaseUserEntity
import com.example.database.room.entities.ActivityLevel
import com.example.database.room.entities.Gender
import com.example.database.room.entities.Goal
import com.example.database.room.entities.UserEntity
import com.example.database.room.entities.WeightLossSpeed

object UserMapper {
    fun toUserEntity(firebaseUserEntity: FirebaseUserEntity): UserEntity {
        return UserEntity(
            id = firebaseUserEntity.id,
            name = firebaseUserEntity.name ?: "",
            email = firebaseUserEntity.email ?: "",
            gender = firebaseUserEntity.gender ?: Gender.PreferNotToSay,
            age = 0,
            height = 0f,
            weight = 0f,
            activityLevel = ActivityLevel.LightActivity,
            goal = Goal.FatLoss,
            products = "",
            weightLossSpeed = WeightLossSpeed.Recommended,
            dailyCalories = 0,
            dailyProteins = 0f,
            dailyFats = 0f,
            dailyCarbs = 0f,
        )
    }

    fun toFirebaseUserEntity(userEntity: UserEntity): FirebaseUserEntity {
        return FirebaseUserEntity(
            id = userEntity.id,
            name = userEntity.name,
            email = userEntity.email,
            gender = userEntity.gender
        )
    }

    //  fun toUserUI(userEntity: UserEntity): UserUI {
    //      return UserUI(
    //          id = userEntity.id,
    //          name = userEntity.name,
    //          email = userEntity.email,
    //          gender = userEntity.gender
    //      )
    //  }
}