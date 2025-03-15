package com.example.fofitest

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LandingScreen(navController: NavController) {
    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(Color.White)
    )

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.mobilelogo2),
            contentDescription = "",
            modifier = Modifier
                .size(250.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colorResource(id = R.color.fofi_orange))
                .clickable { navController.navigate("screen_Login") },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colorResource(id = R.color.fofi_orange))
                .clickable { navController.navigate("screen_Signup") },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Signup",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview (showBackground = true)
@Composable
fun ShowLandingScreen() {
    LandingScreen(rememberNavController())
}