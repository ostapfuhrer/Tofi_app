package com.example.datastore.onboarding_datastore

import android.content.Context

interface OnboardingDataStore {
    suspend fun saveOnboardingData(context: Context)
    suspend fun getOnboardingData(context: Context)
}