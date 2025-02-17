package com.example.fofitest

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun ForgotPasswordScreen(navController: NavController){
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.arrow_back),
                contentDescription = "Back Button",
                modifier = Modifier
                    .size(35.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .clickable { navController.navigate("screen_Login") }
            )
            Text (text = "Forgot Password?", fontSize = 25.sp, modifier = Modifier
                .padding(start = 58.dp)
            )

        }
        Image(
            painter = painterResource(R.drawable.forgot_password_img),
            contentDescription = "Forgot Password Image",
            modifier = Modifier
                .size(220.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        EmailAddressField(emailAddress) { emailAddress = it }
        Spacer(modifier = Modifier.height(12.dp))
        NewPasswordField (password) { password = it }
        Spacer(modifier = Modifier.height(12.dp))
        ReEnterPasswordField (confirmPassword) { confirmPassword = it }
        Spacer(modifier = Modifier.height(30.dp))
        ResetAccountButton(navController)
    }
}

@Composable
fun EmailAddressField(value: String, onValueChange: (String) -> Unit) {
    val maxChars = 25 // Set character limit

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Email Address", fontSize = 16.sp) },
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
fun NewPasswordField(value: String, onValueChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val maxChars = 18

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "New Password", fontSize = 16.sp) },
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
fun ReEnterPasswordField(value: String, onValueChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val maxChars = 18

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Re-Enter Password", fontSize = 16.sp) },
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
fun ResetAccountButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("screen_Main") },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFAA96C)),
        modifier = Modifier.size(280.dp, 40.dp)
    ) {
        Text(text = "Reset Account", fontSize = 18.sp)
    }
}


@Preview (showBackground = true)
@Composable
fun ShowForgotPasswordScreen() {
    ForgotPasswordScreen(navController = rememberNavController())
}