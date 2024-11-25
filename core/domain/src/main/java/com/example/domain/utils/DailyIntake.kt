package com.example.domain.utils

import com.example.database.room.entities.ActivityLevel
import com.example.database.room.entities.Gender
import com.example.database.room.entities.Goal
import com.example.database.room.entities.GoalSpeed

data class DailyIntake(
    val calories: Int,
    val proteins: Float,
    val fats: Float,
    val carbs: Float
)

fun calculateDailyIntake(
    weight: Float,
    height: Float,
    age: Int,
    gender: Gender,
    activityLevel: ActivityLevel,
    goal: Goal,
    goalSpeed: GoalSpeed
): DailyIntake {
    //base metabolism
    val bm = when (gender) {
        Gender.Male -> 10 * weight + 6.25 * height - 5 * age + 5
        Gender.Female -> 10 * weight + 6.25 * height - 5 * age - 161
        Gender.Other -> 10 * weight + 6.25 * height - 5 * age
    }

    val activityMultiplier = when (activityLevel) {
        ActivityLevel.Light -> 1.2
        ActivityLevel.Moderate -> 1.375
        ActivityLevel.Active -> 1.55
        ActivityLevel.VeryActive -> 1.725
        ActivityLevel.ProfessionalAthlete -> 1.9
    }

    val goalModifier = when (goalSpeed) {
        GoalSpeed.Slow -> 0.1
        GoalSpeed.Moderate -> 0.2
        GoalSpeed.Fast -> 0.3
    }

    val dailyCalories = when (goal) {
        Goal.GainWeight -> (bm * activityMultiplier * (1 + goalModifier)).toInt()
        Goal.MaintainWeight -> (bm * activityMultiplier).toInt()
        Goal.LoseWeight -> (bm * activityMultiplier * (1 - goalModifier)).toInt()
    }

    // proteins (30%), fats (25%), carbohidrates (45%)
    val proteins = dailyCalories * 0.3f / 4 // 4 kcal on 1г proteins
    val fats = dailyCalories * 0.25f / 9 // 9 kcal on 1г fats
    val carbs = dailyCalories * 0.45f / 4 // 4 kcal on 1г carbohidrates

    return DailyIntake(dailyCalories, proteins, fats, carbs)
}