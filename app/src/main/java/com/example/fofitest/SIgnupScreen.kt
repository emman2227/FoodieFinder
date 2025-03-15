package com.example.fofitest

import RetrofitClient
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun SignupScreen(navController: NavController) {
    var createUsername by remember { mutableStateOf("") }
    var enterEmail by remember { mutableStateOf("") }
    var createPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current


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


            SignupButton(navController, createUsername, enterEmail, createPassword, confirmPassword, isLoading) {
                isLoading = it
            }

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
        label = { Text(text = "Create Username", fontSize = 16.sp, color = Color.Black) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black

        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp), // Prevent stretching
        leadingIcon = {
            Icon(
                tint = Color.Black,
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
        label = { Text(text = "Enter Email", fontSize = 16.sp, color = Color.Black) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp), // Prevent stretching
        leadingIcon = {
            Icon(
                tint = Color.Black,
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
        label = { Text(text = "Create Password", fontSize = 16.sp, color = Color.Black) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp),
        leadingIcon = {
            Icon(
                tint = Color.Black,
                painter = painterResource(id = R.drawable.locked_icon),
                contentDescription = "Locked Icon"
            )
        },
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
        label = { Text(text = "Confirm Password", fontSize = 16.sp, color = Color.Black) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.locked_icon),
                contentDescription = "Locked Icon",
                tint = Color.Black
            )
        },
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
fun SignupButton(
    navController: NavController,
    username: String,
    email: String,
    password: String,
    confirmPassword: String,
    isLoading: Boolean,
    onLoadingChange: (Boolean) -> Unit
) {
    val context = LocalContext.current

    Button(
        onClick = {
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
                return@Button
            }
            if (password != confirmPassword) {
                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@Button
            }

            onLoadingChange(true)

            val apiService = RetrofitClient.apiService
            val call = apiService.registerUser(SignupRequest(username, email, password, confirmPassword))

            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    onLoadingChange(false)

                    val apiResponse = response.body()

                    if (response.isSuccessful && apiResponse != null && apiResponse.status == "success") {
                        Toast.makeText(context, "Signup Successful", Toast.LENGTH_SHORT).show()
                        navController.navigate("screen_Main") {
                            popUpTo("screen_Signup") { inclusive = true } // Avoid going back to signup
                        }
                    } else {
                        Toast.makeText(context, "Signup Failed: ${apiResponse?.message ?: "Unknown error"}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    onLoadingChange(false)
                    Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFAA96C)),
        modifier = Modifier.size(280.dp, 40.dp),
        enabled = !isLoading
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
        } else {
            Text(text = "Signup", fontSize = 18.sp, color = Color.White)
        }
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



