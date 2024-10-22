package com.example.tofi_app.common.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ButtonDefaults.buttonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun SmallButtonWrapContent(
    text: String,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    textColor: Color,
    onClick: () -> Unit,
    selected: Boolean,
    modifier: Modifier = Modifier,
) {
    val buttonBackgroundColor = if (!selected) {
        AppColors.YellowDefault
    } else {
        AppColors.YellowDark
    }

    Button(
        onClick = onClick,
        modifier = modifier
            .wrapContentSize(),
        shape = RoundedCornerShape(8.dp),
        colors = buttonColors(buttonBackgroundColor),
        elevation = buttonElevation(4.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = fontSize,
            fontWeight = fontWeight,
        )
    }
}

@Preview
@Composable
fun SmallButtonWrapContentPreview() {
    SmallButtonWrapContent(
        text = "Chicken",
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        textColor = Color.White,
        onClick = { /*TODO*/ },
        selected = false,
        modifier = Modifier
    )
}