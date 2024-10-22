package com.example.tofi_app.about_user_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tofi_app.R
import com.example.tofi_app.about_user_screen.viewmodel.AboutUserScreenViewModel
import com.example.tofi_app.common.composable.IndicatorRow
import com.example.tofi_app.common.composable.IntroScreenHeader
import com.example.tofi_app.common.composable.MainButton
import com.example.tofi_app.common.composable.SmallButton
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun AboutUserScreen(
    aboutUserScreenViewModel: AboutUserScreenViewModel = hiltViewModel()
) {
    AboutUserScreenUi()
}

@Composable
fun AboutUserScreenUi() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val indicators = listOf(true, false, false, false, false, false, false)
        IndicatorRow(indicators = indicators)
        
        IntroScreenHeader(
            modifier = Modifier.padding(top = 120.dp),
            iconId = R.drawable.ic_about,
            title = "About you",
            description = "calculate the calories for your goal"
        )
        Spacer(modifier = Modifier.weight(0.1f))

        val buttonLabels = listOf("Sex", "Age", "Height", "Weight")

        buttonLabels.forEach { label ->
            SmallButton(
                alignLeftText = label,
                alignRightText = "Select",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textColor = Color.White,
                backgroundColor = AppColors.YellowDefault,
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
            )
        }

        MainButton(
            text = "Continue",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textColor = Color.White,
            backgroundColor = AppColors.YellowDefault,
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 14.dp, bottom = 8.dp)
        )
    }
}

@Preview
@Composable
fun AboutUserScreenPreview() {
    AboutUserScreenUi()
}