package com.example.database.room.entities

import androidx.room.Entity

@Entity(tableName = "user")
data class UserEntity(
    val id: String,
    val name: String?,
    val email:String,
    val gender: Gender,
    val age: Int,
    val height: Float,
    val weight: Float,
    val activityLevel: ActivityLevel,
    val goal: Goal,
    val products: String,
    val weightLossSpeed: WeightLossSpeed,
    val dailyCalories: Int?,
    val dailyProteins: Float?,
    val dailyFats: Float?,
    val dailyCarbs: Float?
)

enum class Gender {
    Male, Female, Other, PreferNotToSay
}

enum class ActivityLevel {
    SedentaryLifeStyle, LightActivity, ModeratelyActivity, VeryActive, ProfessionalAthlete
}

enum class Goal {
    FatLoss, MuscleGain, WeightMaintenance
}

enum class WeightLossSpeed {
    Recommended, Fast, Slow
}