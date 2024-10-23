package com.example.tofi_app.login.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tofi_app.R
import com.example.tofi_app.ui.theme.AppColors

@Composable
fun InputRegisterScreen(
    iconId: Int,
    title: String,
    placeholder: String,
    inputType: KeyboardType,
    onInputChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
        )

        Text(
            text = title,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = "",
            onValueChange = onInputChange,
            placeholder = {
                Text(text = placeholder)
            },
            keyboardOptions = KeyboardOptions(keyboardType = inputType),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
                .background(AppColors.GrayLight)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = AppColors.GrayLight,
                unfocusedContainerColor = AppColors.GrayLight,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
    }
}

@Composable
fun NameInputScreen(onNameChange: (String) -> Unit) {
    InputRegisterScreen(
        iconId = R.drawable.ic_default_user,
        title = "What's your name?",
        placeholder = "Enter your name",
        inputType = KeyboardType.Text,
        onInputChange = onNameChange
    )
}

@Composable
fun EmailInputScreen(onEmailChange: (String) -> Unit) {
    InputRegisterScreen(
        iconId = R.drawable.ic_default_email,
        title = "What's your email?",
        placeholder = "Enter your email",
        inputType = KeyboardType.Email,
        onInputChange = onEmailChange
    )
}

@Composable
fun PasswordInputScreen(onPasswordChange: (String) -> Unit) {
    InputRegisterScreen(
        iconId = R.drawable.ic_default_password,
        title = "Create password",
        placeholder = "Enter your password",
        inputType = KeyboardType.Password,
        onInputChange = onPasswordChange
    )
}

@Preview()
@Composable
fun InputRegisterScreenUIPreview() {
    PasswordInputScreen(onPasswordChange = {})
}
