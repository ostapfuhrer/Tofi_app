package com.example.tofi_app.navigation.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.tofi_app.common.manager.toast.collectToasts
import com.example.tofi_app.navigation.LocalNavController
import com.example.tofi_app.navigation.destination.Destination
import com.example.tofi_app.navigation.getNavController
import com.example.tofi_app.navigation.navigator.NavigationIntent
import com.example.tofi_app.navigation.viewmodel.NavigationViewModel
import com.example.tofi_app.navigation.viewmodel.ToastViewModel
import com.example.tofi_app.splash_screen.navigation.splashScreen
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
    navHostController: NavHostController,
    navigationFlow: SharedFlow<NavigationIntent>
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