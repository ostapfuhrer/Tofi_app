package com.example.tofi_app.common.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ButtonDefaults.buttonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tofi_app.R
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun SmallButton(
    alignLeftText: String,
    alignRightText: String,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    textColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        colors = buttonColors(backgroundColor),
        elevation = buttonElevation(4.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = alignLeftText,
                color = textColor,
                fontSize = fontSize,
                fontWeight = fontWeight
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = alignRightText,
                    color = textColor,
                    fontSize = fontSize,
                    fontWeight = fontWeight
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier
                        .size(10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSmallButton() {
    SmallButton(
        alignLeftText = "Age",
        alignRightText = "Select",
        12.sp,
        fontWeight = FontWeight.Normal,
        textColor = Color.White,
        backgroundColor = AppColors.YellowDefault,
        onClick = { /*TODO*/ },
        modifier = Modifier,
    )
}