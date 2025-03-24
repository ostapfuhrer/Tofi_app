package com.example.tofi_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun getNavController(): NavHostController {
    return LocalNavController.current ?: rememberNavController()
}

val LocalNavController = compositionLocalOf<NavHostController?> { null }