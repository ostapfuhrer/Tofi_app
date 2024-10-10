package com.example.tofi_app.navigation.di

import com.example.tofi_app.navigation.actions.SplashNavigationActionsImpl
import com.example.tofi_app.navigation.navigator.AppNavigator
import com.example.tofi_app.navigation.navigator.AppNavigatorImpl
import com.example.tofi_app.splash_screen.navigation.SplashNavigationActions
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
