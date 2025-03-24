package com.example.tofi_app.navigation.di

import com.example.onboarding.contracts.IntroNavigationContract
import com.example.onboarding.contracts.IntroNavigationContractImpl
import com.example.onboarding.intro.navigation.IntroNavigationActions
import com.example.onboarding.splash.navigation.SplashNavigationActions
import com.example.tofi_app.navigation.actions.IntroNavigationActionsImpl
import com.example.tofi_app.navigation.actions.SplashNavigationActionsImpl
import com.example.tofi_app.navigation.navigator.AppNavigator
import com.example.tofi_app.navigation.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
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

    @Singleton
    @Binds
    abstract fun bindIntroNavigationActions(
        introNavigationActions: IntroNavigationActionsImpl
    ): IntroNavigationActions

    @Module
    @InstallIn(SingletonComponent::class)
    object NavigationProvidesModule {

        @Provides
        @Singleton
        fun provideIntroNavigationContract(): IntroNavigationContract {
            return IntroNavigationContractImpl()
        }
    }
}
