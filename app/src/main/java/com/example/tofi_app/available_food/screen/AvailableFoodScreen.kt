package com.example.tofi_app.available_food.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.tofi_app.common.composable.SelectorTitle
import com.example.tofi_app.common.composable.SmallButtonWrapContent
import com.example.tofi_app.common.model.TextStyleData
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun AvailableFoodScreen() {
    AvailableFoodScreenUI()
}

@Composable
fun AvailableFoodScreenUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp), // Відступи для контейнера
        horizontalAlignment = Alignment.Start,
    ) {
        val indicators = listOf(true, false, false, false, false, false, false)
        IndicatorRow(indicators = indicators)

        IntroScreenHeader(
            modifier = Modifier.padding(top = 120.dp),
            iconId = R.drawable.ic_activity_level,
            title = "Choose the products\navailable to you",
            description = "a ration will be created based on them",
            fontWeight = FontWeight.Bold
        )

        SelectorTitle(
            modifier = Modifier.padding(top = 48.dp),
            textTitle = "Proteins",
            textTitleStyle = TextStyleData(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textColor = Color.Black
            ),
            textSelectCounter = "select at least 2",
            textSelectCounterStyle = TextStyleData(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textColor = Color.Gray
            ),
            textSelectAll = "select All",
            textSelectAllStyle = TextStyleData(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textColor = Color.Black
            )
        )

        val listButtons = listOf(
            "Chicken",
            "Beef",
            "Fish",
            "Canned Food",
            "Egg",
            "Turkey",
            "Legumes",
            "Protein Powder",
            "Sour Milk, Cheese"
        )

        for (i in listButtons.indices step 3) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                for (j in 0 until 3) {
                    if (i + j < listButtons.size) {
                        SmallButtonWrapContent(
                            text = listButtons[i + j],
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            textColor = Color.White,
                            onClick = { /*TODO*/ },
                            selected = false,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }
            }
        }
        SelectorTitle(
            modifier = Modifier.padding(top = 14.dp),
            textTitle = "Carbohydrates",
            textTitleStyle = TextStyleData(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textColor = Color.Black
            ),
            textSelectCounter = "select at least 3",
            textSelectCounterStyle = TextStyleData(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textColor = Color.Gray
            ),
            textSelectAll = "select All",
            textSelectAllStyle = TextStyleData(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textColor = Color.Black
            )
        )
        for (i in listButtons.indices step 3) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                for (j in 0 until 3) {
                    if (i + j < listButtons.size) {
                        SmallButtonWrapContent(
                            text = listButtons[i + j],
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            textColor = Color.White,
                            onClick = { /*TODO*/ },
                            selected = false,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        MainButton(
            text = "Continue",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            onClick = { /*TODO*/ },
            textColor = Color.White,
            backgroundColor = AppColors.YellowDefault,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
fun PreviewAvailableFoodScreenUI() {
    AvailableFoodScreenUI()
}