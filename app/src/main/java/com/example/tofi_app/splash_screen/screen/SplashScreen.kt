package com.example.tofi_app.splash_screen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tofi_app.R
import com.example.tofi_app.splash_screen.viewmodel.SplashScreenViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SplashScreen(
    viewModel: SplashScreenViewModel = hiltViewModel()
) {
    SettingStatusBarColor()
    SplashScreenUI()
}

@Composable
private fun SplashScreenUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background_splash_screen),
            contentDescription = "splashScreen_background",
            contentScale = ContentScale.FillBounds
        )
        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
                .size(64.dp, 84.dp),
            painter = painterResource(id = R.drawable.tofi),
            contentDescription = "splashScreen_logo",
        )
    }
}

@Composable
private fun SettingStatusBarColor() {
    val systemUiController = rememberSystemUiController()
    val isDarkTheme = isSystemInDarkTheme()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }

    DisposableEffect(key1 = systemUiController) {
        this.onDispose {
            systemUiController.setStatusBarColor(
                color = Color.Transparent,
                darkIcons = !isDarkTheme
            )
        }
    }
}

@Composable
@Preview
fun SplashScreenUIPreview() {
    SplashScreenUI()
}
