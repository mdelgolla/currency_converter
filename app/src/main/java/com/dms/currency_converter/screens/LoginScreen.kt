package com.example.mytestapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dms.currency_converter.R
import com.dms.currency_converter.ui.theme.Currency_converterTheme
import com.example.mytestapp.common.DefaultButton
import com.example.mytestapp.common.InputField

@Composable
fun LoginScreen( navigateToHome: () -> Unit) {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "login",
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    6.dp
                ),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
                .alpha(0.6f)
                .clip(
                    CutCornerShape(
                        topStart = 8.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
                .background(MaterialTheme.colorScheme.background)
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(48.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader()
            LoginForm(
                username,
                password,
                onUsernameChange = { username = it },
                onPasswordChange = { password = it })
            Spacer(modifier = Modifier.height(16.dp))
            LoginFooter(navigateToHome)
        }
    }
}

@Composable
fun LoginHeader() {
    Text(
        text = "Welcome to Kotlin",
        fontSize = 48.sp,
        lineHeight = 48.sp,
        fontWeight = FontWeight.ExtraBold
    )
    Text(
        text = "Please Sign in to continue",
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun LoginForm(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    InputField(
        value = username,
        label = "Username",
        placeholder = "Enter your Username",
        onValueChange = onUsernameChange,
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = "Email")
        }
    )
    Spacer(modifier = Modifier.height(8.dp))
    InputField(
        value = password,
        label = "Password",
        placeholder = "Enter your Password",
        onValueChange = onPasswordChange,
        visualTransformation = PasswordVisualTransformation(),
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = "Password")
        }
    )
}

@Composable
fun LoginFooter(navigateToHome: () -> Unit) {
    DefaultButton(text = "Log In", onClick = navigateToHome)
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
private fun DefaultPreview() {
    Currency_converterTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(
                navigateToHome = {}
            )
        }
    }
}