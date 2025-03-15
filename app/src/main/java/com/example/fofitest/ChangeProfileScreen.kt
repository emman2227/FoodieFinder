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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.ColorFilter
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
fun ChangeProfileScreen(navController: NavController) {
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
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
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
                    text = "Profile",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.weight(1.3f))
            }
            Spacer(modifier = Modifier.height(30.dp))
            ProfileHolder()
            Spacer(modifier = Modifier.height(20.dp))
            ChangeProfileButton()
        }
    }
}


@Composable
fun ChangeProfileButton () {
    Box(
        modifier = Modifier
            .width(120.dp) // Set button width
            .height(40.dp) // Set button height
            .clip(RoundedCornerShape(5.dp)) // Rounded corners
            .background(colorResource(id = R.color.fofi_orange)) // Green background
            .clickable {  },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Change Profile",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview (showBackground = true)
@Composable
fun ShowChangeProfileScreen() {
    ChangeProfileScreen(navController = rememberNavController())
}
