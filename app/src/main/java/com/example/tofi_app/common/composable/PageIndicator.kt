package com.example.tofi_app.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun IndicatorRow(
    indicators: List<Boolean>,
    modifier: Modifier = Modifier,
    activeColor: Color = AppColors.YellowDark,
    inactiveColor: Color = AppColors.YellowLight
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        indicators.forEach { isActive ->
            IndicatorDot(
                isActive = isActive,
                activeColor = activeColor,
                inactiveColor = inactiveColor,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
    }
}

@Composable
fun IndicatorDot(
    isActive: Boolean,
    activeColor: Color,
    inactiveColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(40.dp, 8.dp)
            .background(
                color = if (isActive) activeColor else inactiveColor,
                shape = MaterialTheme.shapes.small
            )
    )
}