package com.example.onboarding.navigation.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.onboarding.common.manager.toast.collectToasts
import com.example.onboarding.navigation.LocalNavController
import com.example.onboarding.navigation.destination.Destination
import com.example.onboarding.navigation.getNavController
import com.example.onboarding.navigation.navigator.NavigationIntent
import com.example.onboarding.navigation.viewmodel.NavigationViewModel
import com.example.onboarding.navigation.viewmodel.ToastViewModel
import com.example.onboarding.splash.navigation.splashScreen
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun Root(
    navigationViewModel: NavigationViewModel = hiltViewModel(),
    toastViewModel: ToastViewModel = hiltViewModel()
) {
    CompositionLocalProvider(
        LocalNavController provides getNavController()
    ) {
        NavigationEffects(
            navHostController = getNavController(),
            navigationFlow = navigationViewModel.navigationFlow,
        )

        NavHost(
            navController = getNavController(),
            startDestination = Destination.SplashScreen.fullRoute
        ) {
            splashScreen()
        }
    }

    toastViewModel.toastFlow.collectToasts()
}

@Composable
fun NavigationEffects(
    navHostController: NavHostController, navigationFlow: SharedFlow<NavigationIntent>
) {
    LaunchedEffect(navHostController) {
        navigationFlow.collect { intent ->
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}