package com.example.fofitest

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
fun LoginScreen(navController: NavController) {
    var enterEmail by remember { mutableStateOf("") }
    var enterPassword by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 150.dp)
                .background(color = Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            AuthTabs(navController)
            Spacer(modifier = Modifier.height(25.dp))
            EmailInputField(enterEmail) { enterEmail = it }
            Spacer(modifier = Modifier.height(12.dp))
            PasswordInputField(enterPassword) { enterPassword = it }
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(45.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RememberMeSection(rememberMe) { rememberMe = it }
                ForgotPasswordNav(navController) }
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(navController, enterEmail, enterPassword, isLoading) { isLoading = it }
            Spacer(modifier = Modifier.height(16.dp))
            SignupPrompt(navController)
        }
    }
    }

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.mobilelogo2),
        contentDescription = "MobileLogo",
        modifier = Modifier.size(220.dp)
    )
}

@Composable
fun AuthTabs(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Login", fontSize = 18.sp, color = Color(0xFFFAA96C))
            HorizontalDivider(
                color = Color(0xFFFAA96C),
                thickness = 1.dp,
                modifier = Modifier.width(180.dp)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Signup", fontSize = 18.sp, modifier = Modifier.clickable {
                navController.navigate("screen_Signup")
            })
            HorizontalDivider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier.width(180.dp)
            )
        }
    }
}

@Composable
fun EmailInputField(value: String, onValueChange: (String) -> Unit) {
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
fun PasswordInputField(value: String, onValueChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val maxChars = 18

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Enter Password", fontSize = 16.sp, color = Color.Black) },
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
fun RememberMeSection(checkedState: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFFFAA96C))
        )
        Text(text = "Remember me", fontSize = 16.sp, modifier = Modifier)
    }
}

@Composable
fun ForgotPasswordNav (navController: NavController) {
    Text(text = "Forgot Password?", fontSize = 16.sp, color = Color(0xFFFAA96C), modifier = Modifier
        .padding(end = 12.dp)
        .clickable {
            navController.navigate("screen_Main")
        }
    )
}

@Composable
fun LoginButton(
    navController: NavController,
    email: String,
    password: String,
    isLoading: Boolean,
    onLoadingChange: (Boolean) -> Unit
) {
    val context = LocalContext.current

    Button(
        onClick = {
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Email and password are required", Toast.LENGTH_SHORT).show()
                return@Button
            }

            onLoadingChange(true)

            val apiService = RetrofitClient.apiService
            val call = apiService.loginUser(LoginRequest(email, password))

            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    onLoadingChange(false)

                    val apiResponse = response.body()

                    if (response.isSuccessful && apiResponse != null && apiResponse.status == "success") {
                        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                        navController.navigate("screen_Main") {
                            popUpTo("screen_Login") { inclusive = true }
                        }
                    } else {
                        Toast.makeText(context, "Login Failed: ${apiResponse?.message ?: "Invalid credentials"}", Toast.LENGTH_SHORT).show()
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
            Text(text = "Login", fontSize = 18.sp, color = Color.White)
        }
    }
}


@Composable
fun SignupPrompt(navController: NavController) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Don't have an account?", fontSize = 16.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Sign up now", fontSize = 16.sp, color = Color(0xFFFAA96C),
            modifier = Modifier.clickable {
                navController.navigate("screen_signUp")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLoginScreen() {
    LoginScreen(navController = rememberNavController())
}
