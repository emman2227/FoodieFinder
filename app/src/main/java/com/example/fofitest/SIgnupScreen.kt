package com.example.fofitest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignupScreen(navController: NavController) {
    var createUsername by remember { mutableStateOf("") }
    var enterEmail by remember { mutableStateOf("") }
    var createPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 75.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.mobilelogo2),
                contentDescription = "MobileLogo",
                modifier = Modifier.size(220.dp)
            )

            AuthHeader(navController)

            Spacer(modifier = Modifier.height(25.dp))

            CreateUsernameField(createUsername) { createUsername = it }
            Spacer(modifier = Modifier.height(12.dp))
            EnterEmailField(enterEmail) { enterEmail = it }
            Spacer(modifier = Modifier.height(12.dp))
            CreatePasswordField(createPassword) { createPassword = it }
            Spacer(modifier = Modifier.height(12.dp))
            ConfirmPasswordField(confirmPassword) { confirmPassword = it }
            Spacer(modifier = Modifier.height(25.dp))

            SignupButton(navController)
            Spacer(modifier = Modifier.height(16.dp))
            LoginPrompt(navController)
        }
    }
    }

@Composable
fun AuthHeader(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Login", fontSize = 18.sp,
                modifier = Modifier.clickable {
                    navController.navigate("screen_Login")
                })
            HorizontalDivider(
                color = Color(0xFF000000),
                thickness = 1.dp,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .width(180.dp)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Signup", fontSize = 18.sp, color = Color(0xFFFAA96C))
            HorizontalDivider(
                color = Color(0xFFFAA96C),
                thickness = 1.dp,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .width(180.dp)
            )
        }
    }
}

@Composable
fun CreateUsernameField(value: String, onValueChange: (String) -> Unit) {
    val maxChars = 25 // Set character limit

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Create Username", fontSize = 16.sp) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedTextColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp), // Prevent stretching
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.user_icon),
                contentDescription = "User"
            )
        }
    )
}


@Composable
fun EnterEmailField(value: String, onValueChange: (String) -> Unit) {
    val maxChars = 25 // Set character limit

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Enter Email", fontSize = 16.sp) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedTextColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp), // Prevent stretching
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.email_icon),
                contentDescription = "Email Icon"
            )
        }
    )
}

@Composable
fun CreatePasswordField(value: String, onValueChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val maxChars = 18

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Create Password", fontSize = 16.sp) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.locked_icon),
                contentDescription = "Locked Icon"
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(
                    id = if (isPasswordVisible) R.drawable.show_icon else R.drawable.hide_icon
                ),
                contentDescription = if (isPasswordVisible) "Hide Password" else "Show Password",
                modifier = Modifier
                    .clickable { isPasswordVisible = !isPasswordVisible }
                    .size(24.dp) // Adjust icon size if needed
            )
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}


@Composable
fun ConfirmPasswordField(value: String, onValueChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val maxChars = 18

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Confirm Password", fontSize = 16.sp) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.locked_icon),
                contentDescription = "Locked Icon"
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(
                    id = if (isPasswordVisible) R.drawable.show_icon else R.drawable.hide_icon
                ),
                contentDescription = if (isPasswordVisible) "Hide Password" else "Show Password",
                modifier = Modifier
                    .clickable { isPasswordVisible = !isPasswordVisible }
                    .size(24.dp) // Adjust icon size if needed
            )
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}


@Composable
fun SignupButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("screen_Main") },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFAA96C)),
        modifier = Modifier.size(280.dp, 40.dp)
    ) {
        Text(text = "Signup", fontSize = 18.sp)
    }
}

@Composable
fun LoginPrompt(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Already have an account?", fontSize = 16.sp)
        Text(text = "Login now", fontSize = 16.sp, color = Color(0xFFFAA96C),
            modifier = Modifier.clickable {
                navController.navigate("screen_Login")
            })
    }
}

@Preview(showBackground = true)
@Composable
fun ShowSignupScreen() {
    SignupScreen(navController = rememberNavController())
}