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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun ItemContent (navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
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
                                navController.navigate("screen_ShopContent")
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
                            .padding(8.dp) // Padding inside the background
                            .clickable { /* Handle back action */ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.favorite), // Your vector drawable
                            contentDescription = "Back Button",
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sampleimg2),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(start = 20.dp, top = 20.dp, bottom = 10.dp)
            ) {
                Column (
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    ProductNameContainer()
                    Spacer(modifier = Modifier.height(2.dp))
                    ItemDescriptionContainer()
                }
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 20.dp)
            ){
                Column {
                    ItemPriceContainer()
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(20.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    PreOrderBtn {  }
                    Spacer(
                        modifier = Modifier
                            .height(15.dp)
                    )
                    CancelBtn {  }
                }
            }

        }
    }
}

@Composable
fun ProductNameContainer() {
    Text(
        text = "Product Name",
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )
}

@Composable
fun ItemDescriptionContainer() {
    Text(
        text = "Project Description blah blah blah blah blah blah blah blah blah blah blah blah",
        color = Color.Gray,
        fontSize = 16.sp
    )
}

@Composable
fun ItemPriceContainer() {
    Text(
        text = "Item Price",
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )
}

@Composable
fun PreOrderBtn(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(220.dp) // Set button width
            .height(50.dp) // Set button height
            .clip(RoundedCornerShape(10.dp)) // Rounded corners
            .background(colorResource(id = R.color.fofi_orange)) // Green background
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Pre-Order",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CancelBtn(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(220.dp) // Set button width
            .height(50.dp) // Set button height
            .clip(RoundedCornerShape(10.dp)) // Rounded corners
            .background(Color.Gray) // Green background
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Cancel",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview (showBackground = true)
@Composable
fun ShowItemContent () {
    ItemContent(navController = rememberNavController())
}