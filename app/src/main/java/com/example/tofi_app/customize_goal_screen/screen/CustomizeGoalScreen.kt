package com.example.tofi_app.customize_goal_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.example.tofi_app.common.composable.IndicatorRow
import com.example.tofi_app.common.composable.IntroScreenHeader
import com.example.tofi_app.common.composable.MainButton
import com.example.tofi_app.common.composable.SmallButton
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun CustomizeGoalScreen(

) {
    CustomizeGoalScreenUI()
}

@Composable
fun CustomizeGoalScreenUI() {
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
            iconId = R.drawable.ic_customize_goal,
            title = "Customize your goal",
            description = "this is the last step"
        )
        Spacer(modifier = Modifier.weight(0.1f))

        val buttonLabels = listOf("Current weight", "Goal weight", "Speed result")

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
fun CustomizeGoalScreenUIPreview() {
    CustomizeGoalScreenUI()
}