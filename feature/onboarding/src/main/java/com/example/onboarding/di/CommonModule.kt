package com.example.onboarding.di

import com.example.onboarding.common.provider.ResourceProvider
import com.example.onboarding.common.provider.ResourceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonModule {
    @Binds
    abstract fun bindResourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider
}