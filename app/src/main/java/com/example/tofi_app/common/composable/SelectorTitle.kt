package com.example.tofi_app.common.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectorTitle(
    textTitle: String,
    textSelectCounter:String,
    textSelectAll:String,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    textColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                modifier = Modifier,
                text = textTitle,
                color = textColor,
                fontSize = fontSize,
                fontWeight = fontWeight
            )
            Text(
                text = textSelectCounter,
                color = textColor,
                fontSize = fontSize,
                fontWeight = fontWeight
            )
        }
        Text(
            text = textSelectAll,
            color = textColor,
            fontSize = fontSize,
            fontWeight = fontWeight
        )
    }
}

@Preview
@Composable
fun SelectorTitlePreview() {
    SelectorTitle(
        textTitle = "Proteins",
        textSelectCounter = "select at least 2",
        textSelectAll = "select all",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        textColor = Color.Black,
    )
}