package com.example.fofitest

import android.accounts.Account
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.contentReceiver
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AccountScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Centered Text and Right-aligned Icon
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Account", style = MaterialTheme.typography.titleLarge
                    )
                }

                // Icon at the top-right

                Icon(
                    imageVector = Icons.Default.Edit, // Replace with your vector icon
                    contentDescription = "Settings",
                    modifier = Modifier
                        .align(Alignment.CenterEnd) // Aligns the icon to the right
                        .padding(end = 16.dp) // Add some padding from the right
                        .size(24.dp) // Adjust size if needed
                        .clickable {
                            navController.navigate("screen_EditProfile")
                        },
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            ProfileHolder()
            Spacer(modifier = Modifier.height(10.dp))
            NameHolder()
        }
    }
}


@Composable
fun ProfileHolder(imageRes: Int? = null, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(150.dp) // Adjust size as needed
            .clip(CircleShape) // Clip the box to a circle
            .background(colorResource(id = R.color.fofi_orange)) // Background color if no image is loaded
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentScale = ContentScale.Crop,
            contentDescription = "Profile Image",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun NameHolder(){
    Text(text = "Username", style = MaterialTheme.typography.titleSmall)

}

@Preview (showBackground = true)
@Composable
fun ShowAccountScreen() {
    AccountScreen(navController = rememberNavController())
}
