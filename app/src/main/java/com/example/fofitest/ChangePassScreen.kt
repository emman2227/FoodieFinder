package com.example.fofitest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ChangePassScreen(navController: NavController) {
    var currPass by remember { mutableStateOf("") }
    var newPass by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .padding(4.dp) // Reduce external padding to bring it closer
                        .size(24.dp) // Set a fixed size for the box (adjust as needed)
                        .clip(CircleShape) // Makes it perfectly round
                        .background(colorResource(id = R.color.fofi_orange))
                        .clickable {
                            navController.navigate("settings_screen")
                        } // Ensure it's still clickable
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "Back Button",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .size(14.dp) // Adjust size of the icon
                            .align(Alignment.Center) // Center the icon inside the Box
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Change Password",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1.5f))
            }
            Spacer(modifier = Modifier.height(40.dp))
            CurrPassField(currPass) { currPass = it }
            Spacer(modifier = Modifier.height(20.dp))
            NewPassField(newPass) { newPass = it }
            Spacer(modifier = Modifier.weight(1f))
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)

            ) {
                CancelButton {  }
                DoneButton {  }
            }
        }
    }
}

@Composable
fun CurrPassField(value: String, onValueChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val maxChars = 18

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Current Password", fontSize = 16.sp, color = Color.Black) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp),
        trailingIcon = {
            Icon(
                tint = Color.Black,
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
fun NewPassField(value: String, onValueChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val maxChars = 18

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "New Password", fontSize = 16.sp, color = Color.Black) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp),
        trailingIcon = {
            Icon(
                tint = Color.Black,
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

@Preview(showBackground = true)
@Composable
fun ShowChangePassScreen() {
    ChangePassScreen(rememberNavController())
}