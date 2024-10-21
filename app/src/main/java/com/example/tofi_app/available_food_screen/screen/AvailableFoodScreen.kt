package com.example.tofi_app.available_food_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tofi_app.R
import com.example.tofi_app.common.composable.IndicatorRow
import com.example.tofi_app.common.composable.IntroScreenHeader

@Composable
fun AvailableFoodScreen() {
    AvailableFoodScreenUI()
}

@Composable
fun AvailableFoodScreenUI() {
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
            title = "Choose the products available to you ",
            description = "a ration will be created based on them"
        )
        Spacer(modifier = Modifier.weight(1f))

    }
}

@Preview
@Composable
fun PreviewAvailableFoodScreenUI() {
    AvailableFoodScreenUI()
}