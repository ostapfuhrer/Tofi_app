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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tofi_app.common.model.TextStyleData

@Composable
fun SelectorTitle(
    modifier: Modifier,
    textTitle: String,
    textTitleStyle: TextStyleData,

    textSelectCounter: String,
    textSelectCounterStyle: TextStyleData,

    textSelectAll: String,
    textSelectAllStyle: TextStyleData,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            StyledText(text = textTitle, styleData = textTitleStyle)
            StyledText(text = textSelectCounter, styleData = textSelectCounterStyle)
        }
        StyledText(text = textSelectAll, styleData = textSelectAllStyle)
    }
}

@Composable
fun StyledText(
    text: String,
    styleData: TextStyleData
) {
    Text(
        text = text,
        style = TextStyle(
            color = styleData.textColor,
            fontSize = styleData.fontSize,
            fontWeight = styleData.fontWeight
        )
    )
}

@Preview
@Composable
fun SelectorTitlePreview() {
    SelectorTitle(
        modifier = Modifier.padding(top = 48.dp),
        textTitle = "Proteins",
        textTitleStyle = TextStyleData(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textColor = Color.Black
        ),
        textSelectCounter = "select at least 2",
        textSelectCounterStyle = TextStyleData(
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            textColor = Color.Gray
        ),
        textSelectAll = "Select All",
        textSelectAllStyle = TextStyleData(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textColor = Color.Black
        )
    )
}