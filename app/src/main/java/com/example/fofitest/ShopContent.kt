package com.example.fofitest

import android.graphics.Paint.Align
import android.util.Log
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.compose.rememberNavController

@Composable
fun ShopContent(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState()) // Enables scrolling
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(16.dp) // Adds some padding from the edges
                            .clip(RoundedCornerShape(50)) // Optional: Makes it rounded
                            .background(colorResource(id = R.color.fofi_orange)) // Optional: Adds a semi-transparent background
                            .padding(8.dp) // Padding inside the background
                            .clickable {
                                navController.navigate("main_screen")
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back), // Your vector drawable
                            contentDescription = "Back Button",
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(16.dp) // Adds some padding from the edges
                            .clip(RoundedCornerShape(50)) // Optional: Makes it rounded
                            .background(colorResource(id = R.color.fofi_orange)) // Optional: Adds a semi-transparent background
                            .clickable { navController.navigate("screen_Bingo") }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bingo_btn), // Your vector drawable
                            contentDescription = ""

                        )
                    }
                }
            }

            // Shop Image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sampleimg),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                        .matchParentSize()
                )
            }

            // Shop Info Box
            Box(
                modifier = Modifier
                    .offset(y = (-150.dp / 3)) // Moves the entire box up
                    .width(320.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .border(0.5.dp, Color.Black, RoundedCornerShape(30.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ShopNameContainer()
                    WorkingHoursContainer()
                    LocationContainer()

                }
            }

            // Shop Description
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = "Shop Description",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ShopDesContainer()

                }
            }
            Spacer(modifier = Modifier
                .height(10.dp))
            ShopGrid(navController)
        }
    }
}

@Composable
fun ShopNameContainer() {
    Text(
        text = "Shop Name",
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )
}

@Composable
fun WorkingHoursContainer() {
    Text(
        text = "Shop Working Hours",
        fontSize = 16.sp,
        color = Color.Black
    )
}
@Composable
fun LocationContainer() {
    Text(
        text = "Shop Location",
        fontSize = 16.sp,
        color = Color.Black
    )
}

@Composable
fun ShopDesContainer() {
    Text(
        text = "Shop description Shop description Shop description Shop description...",
        color = Color.Gray,
        fontSize = 12.sp
    )
}

// Move ShopGrid OUTSIDE of ShopContent
@Composable
fun ShopGrid(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(3) {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Item(navController)
                Item(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowShopContent() {
    ShopContent(navController = rememberNavController())
}
