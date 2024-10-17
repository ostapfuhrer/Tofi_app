package com.example.tofi_app.intro_screen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tofi_app.R
import com.example.tofi_app.common.composable.MainButton
import com.example.tofi_app.intro_screen.viewmodel.IntroViewModel
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun IntroScreen(
    introViewModel: IntroViewModel = hiltViewModel()
) {
    IntroScreenUi()
}

@Composable
fun IntroScreenUi() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_intro),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.background_vagatables_intro),
            contentDescription = null,
            modifier = Modifier
                .width(500.dp)
                .height(500.dp)
                .padding(start = 144.dp)
                .align(Alignment.CenterEnd),
            contentScale = ContentScale.Fit
        )
        MainButton(
            text = "Start Now",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            onClick = { /*TODO*/ },
            textColor = Color.White,
            backgroundColor = AppColors.YellowDefault,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 36.dp, start = 8.dp, end = 8.dp)
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account?",
                color = Color.Black,
            )
            Text(
                text = "Log In",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
                modifier = Modifier
                    .clickable {}
                    .padding(start = 4.dp)

            )
        }
    }
}

@Preview
@Composable
fun PreviewIntro() {
    IntroScreenUi()
}