package com.example.tofi_app.activity_level_screen.screen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tofi_app.R
import com.example.tofi_app.common.composable.IndicatorRow
import com.example.tofi_app.common.composable.IntroScreenHeader
import com.example.tofi_app.common.composable.LargeButton
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun ActivityLevelScreen() {
    ActivityLevelScreenUI()
}

@Composable
fun ActivityLevelScreenUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val indicators = listOf(true, false, false, false, false, false, false)
        IndicatorRow(indicators = indicators)

        Spacer(modifier = Modifier.height(120.dp))
        IntroScreenHeader(
            iconId = R.drawable.ic_activity_level,
            title = "Whats your activity level?",
            description = "We will help you choose calories for your goals"
        )
        Spacer(modifier = Modifier.weight(1f))

        val buttonLabels = listOf(
            "sedentary lifestyle",
            "light activity",
            "moderately active",
            "very active",
            "professional athlete"
        )

        buttonLabels.forEach { label ->
            LargeButton(
                text = label,
                textColor = Color.White,
                backgroundColor = AppColors.YellowDefault,
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewActivityLevelScreenUI() {
    ActivityLevelScreenUI()
}