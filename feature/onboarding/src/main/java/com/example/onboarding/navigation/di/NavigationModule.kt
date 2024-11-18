package com.example.onboarding.navigation.di

import com.example.onboarding.navigation.actions.SplashNavigationActionsImpl
import com.example.onboarding.navigation.navigator.AppNavigator
import com.example.onboarding.navigation.navigator.AppNavigatorImpl
import com.example.onboarding.splash.navigation.SplashNavigationActions
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {
    @Singleton
    @Binds
    abstract fun bindAppNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator

    @Singleton
    @Binds
    abstract fun bindSplashNavigationActions(
        splashNavigationActions: SplashNavigationActionsImpl
    ): SplashNavigationActions
}
