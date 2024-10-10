package com.example.tofi_app.common.composable

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ButtonDefaults.buttonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainButton(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(340.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        colors = buttonColors(backgroundColor),
        elevation = buttonElevation(4.dp)
    ) {
        Text(text = text, color = textColor)
    }
}
