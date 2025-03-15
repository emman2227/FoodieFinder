package com.example.fofitest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ChangeUsernameScreen(navController: NavController) {
    var changeUser by remember { mutableStateOf("") }

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
                    text = "Change Username",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1.8f))

            }
            Spacer(modifier = Modifier.height(40.dp))
            ChangeUserField(changeUser) { changeUser = it }
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
fun ChangeUserField(value: String, onValueChange: (String) -> Unit) {
    val maxChars = 20 // Set character limit for username

    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            if (newText.length <= maxChars && !newText.contains("\n")) { // Prevent Enter key
                onValueChange(newText)
            }
        },
        label = { Text(text = "Change Username", fontSize = 16.sp, color = Color.Black) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedTextColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.widthIn(min = 280.dp, max = 280.dp), // Prevent stretching

    )
}

@Composable
fun DoneButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(120.dp) // Set button width
            .height(48.dp) // Set button height
            .clip(RoundedCornerShape(5.dp)) // Rounded corners
            .background(colorResource(id = R.color.fofi_orange)) // Green background
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Done",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CancelButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(120.dp) // Set button width
            .height(48.dp) // Set button height
            .border(1.dp, colorResource(R.color.fofi_orange), RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(5.dp)) // Rounded corners
            .background(Color.White) // Green background
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Cancel",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ShowChangeUsername() {
    ChangeUsernameScreen(rememberNavController())
}