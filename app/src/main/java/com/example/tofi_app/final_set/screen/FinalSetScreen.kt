package com.example.tofi_app.final_set.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tofi_app.R
import com.example.tofi_app.common.composable.IndicatorRow
import com.example.tofi_app.common.composable.IntroScreenHeader
import com.example.tofi_app.common.composable.MainButton
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun FinalSetScreen() {
    FinalSetScreenUI()
}

@Composable
fun FinalSetScreenUI() {
    val cardPadding = 16.dp
    val circleSize = 80.dp
    val circleBorderWidth = 8.dp
    val spacerHeight = 16.dp
    val indicators = listOf(false, false, false, false, false, false, true)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IndicatorRow(indicators = indicators)

        IntroScreenHeader(
            modifier = Modifier.padding(top = 120.dp),
            iconId = R.drawable.ic_done,
            title = "You’re all set!",
            description = "Your daily nutrition goals",
            fontWeight = FontWeight.Bold
        )

        NutritionCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(cardPadding),
            circleSize = circleSize,
            circleBorderWidth = circleBorderWidth,
            spacerHeight = spacerHeight
        )

        Spacer(modifier = Modifier.weight(0.1f))

        MainButton(
            text = "Let’s start!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textColor = Color.White,
            backgroundColor = AppColors.YellowDefault,
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(
                start = 8.dp,
                end = 8.dp,
                top = 14.dp,
                bottom = 8.dp
            )
        )
    }
}

@Composable
fun NutritionCard(
    modifier: Modifier = Modifier,
    circleSize: Dp,
    circleBorderWidth: Dp,
    spacerHeight: Dp
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = AppColors.GrayLight)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalorieCircle(
                    circleSize = circleSize,
                    borderWidth = circleBorderWidth
                )
                Spacer(modifier = Modifier.width(spacerHeight))
                NutrientsColumn()
            }

            Spacer(modifier = Modifier.height(spacerHeight))

            Text(
                text = "1886 kcal is the midpoint of your\n" +
                        "recommended calorie range of 1700 to 2100",
                style = TextStyle(fontSize = 12.sp),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp)
            )
        }
    }
}

@Composable
fun CalorieCircle(circleSize: Dp, borderWidth: Dp) {
    Box(
        modifier = Modifier
            .size(circleSize)
            .border(
                width = borderWidth,
                color = AppColors.YellowLight,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "1886\nkcal",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun NutrientsColumn() {
    Column(modifier = Modifier.fillMaxWidth()) {
        NutrientRow("Protein", "100g")
        NutrientRow("Carbohydrates", "250g")
        NutrientRow("Fat", "70g")
    }
}

@Composable
fun NutrientRow(nutrient: String, amount: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = nutrient,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = amount,
                style = TextStyle(fontSize = 12.sp),
                modifier = Modifier.padding(top = 4.dp),
                fontWeight = FontWeight.Bold
            )
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 4.dp,
            color = AppColors.YellowLight
        )
    }
}

@Preview
@Composable
fun FinalSetScreenUIPreview() {
    FinalSetScreenUI()
}