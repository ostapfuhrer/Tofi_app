package com.example.model.ondoarding

import kotlinx.serialization.Serializable

@Serializable
data class OnboardingDataModel(
    val goal: Goal? = null,
    val sex: String? = null,
    val age: Int? = null,
    val height: Float? = null,
    val weight: Float? = null,
    val activityLevel: ActivityLevel? = null,
    val availableFood: Food? = null,
    val currentWeight: Float? = null,
    val goalWeight: Float? = null,
    val speedResult: SpeedResult? = null
)

@Serializable
enum class Goal {
    FAT_LOSS, MUSCLE_GAIN, WEIGHT_MAINTENANCE
}

@Serializable
enum class ActivityLevel {
    SEDENTARY, LIGHT_ACTIVITY, MODERATELY_ACTIVE, VERY_ACTIVE, PROFESSIONAL_ATHLETE
}

@Serializable
enum class SpeedResult {
    RECOMMENDED, FAST, SLOW
}

@Serializable
data class Food(
    val proteinFoods: List<String> = emptyList(),
    val carbFoods: List<String> = emptyList()
)