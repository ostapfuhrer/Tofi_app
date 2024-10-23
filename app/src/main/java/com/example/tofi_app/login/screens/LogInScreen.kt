package com.example.tofi_app.login.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tofi_app.R
import com.example.tofi_app.common.composable.IntroScreenHeader
import com.example.tofi_app.common.composable.MainButton
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun LogInScreen() {
    LogInScreenUI()
}

@Composable
fun LogInScreenUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IntroScreenHeader(
            modifier = Modifier.padding(top = 240.dp),
            iconId = R.drawable.ic_join,
            title = "Join now to start",
            description = "",
            fontWeight = FontWeight.Light
        )
        MainButton(
            text = "Continue with Google",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textColor = Color.White,
            backgroundColor = AppColors.YellowDefault,
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
        MainButton(
            text = "Continue with Email",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textColor = Color.White,
            backgroundColor = Color.Gray,
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
    }
}

@Preview
@Composable
fun LogInScreenUIPreview() {
    LogInScreenUI()
}