package com.example.domain.utils

import com.example.database.R
import com.example.database.room.entities.ActivityLevel
import com.example.database.room.entities.Gender
import com.example.database.room.entities.Goal
import com.example.database.room.entities.WeightLossSpeed

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
    weightLossSpeed: WeightLossSpeed,
): DailyIntake {
    //base metabolism
    val bm = when (gender) {
        Gender.Male -> 10 * weight + 6.25 * height - 5 * age + 5
        Gender.Female -> 10 * weight + 6.25 * height - 5 * age - 161
        Gender.Other -> 10 * weight + 6.25 * height - 5 * age
        Gender.PreferNotToSay -> 10 * weight + 6.25 * height - 5 * age
    }

    val activityMultiplier = when (activityLevel) {
        ActivityLevel.LightActivity -> 1.2
        ActivityLevel.ModeratelyActivity -> 1.375
        ActivityLevel.SedentaryLifeStyle -> 1.55
        ActivityLevel.VeryActive -> 1.725
        ActivityLevel.ProfessionalAthlete -> 1.9
    }

    val goalModifier = when (weightLossSpeed) {
        WeightLossSpeed.Slow -> 0.1
        WeightLossSpeed.Recommended -> 0.2
        WeightLossSpeed.Fast -> 0.3
    }

    val dailyCalories = when (goal) {
        Goal.MuscleGain -> (bm * activityMultiplier * (1 + goalModifier)).toInt()
        Goal.WeightMaintenance -> (bm * activityMultiplier).toInt()
        Goal.FatLoss -> (bm * activityMultiplier * (1 - goalModifier)).toInt()
    }

    // proteins (30%), fats (25%), carbohidrates (45%)
    val proteins = dailyCalories * 0.3f / 4 // 4 kcal on 1г proteins
    val fats = dailyCalories * 0.25f / 9 // 9 kcal on 1г fats
    val carbs = dailyCalories * 0.45f / 4 // 4 kcal on 1г carbohidrates

    return DailyIntake(dailyCalories, proteins, fats, carbs)
}

fun Gender.getResId(): Int {
    return when (this) {
        Gender.Male -> R.string.gender_male
        Gender.Female -> R.string.gender_female
        Gender.Other -> R.string.gender_other
        Gender.PreferNotToSay -> R.string.prefer_not_to_say
    }
}

