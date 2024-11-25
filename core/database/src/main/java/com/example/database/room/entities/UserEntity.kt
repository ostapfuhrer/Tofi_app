package com.example.database.room.entities

import androidx.room.Entity

@Entity(tableName = "user")
data class UserEntity(
    val id: String,
    val name: String?,
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Float,
    val activityLevel: ActivityLevel,
    val goal: Goal,
    val products: List<String>,
    val goalSpeed: GoalSpeed,
    val dailyCalories: Int?,
    val dailyProteins: Float?,
    val dailyFats: Float?,
    val dailyCarbs: Float?
)

enum class Gender {
    Male, Female, Other
}

enum class ActivityLevel {
    Light, Moderate, Active, VeryActive, ProfessionalAthlete
}

enum class Goal {
    GainWeight, MaintainWeight, LoseWeight
}

enum class GoalSpeed {
    Slow, Moderate, Fast
}