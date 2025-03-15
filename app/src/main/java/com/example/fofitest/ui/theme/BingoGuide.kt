package com.example.fofitest.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fofitest.R

@Composable
fun BingoGuide(navController: NavController) {
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
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(50))
                        .background(colorResource(id = R.color.fofi_orange))
                        .padding(8.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back), // Your vector drawable
                        contentDescription = "Back Button",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .clickable {
                                navController.navigate("screen_Bingo")
                            }
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .width(280.dp)
                    .height(500.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFF8DBD0))
                    .border(0.5.dp, Color.Black, shape = RoundedCornerShape(20.dp))
            ) {
                Column (
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "Full Bingo Challenge - How it Works?",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "The Full Bingo Challenge is your gateway to exciting" +
                                " rewards! Earn exclusive discounts by completing your Bingo card " +
                                "at participating food shops." ,
                        color = Color.Black,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "How to participate?",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "1. Make purchase at any participating shop.",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "2. Each qualifying purchase fills a slot on your Bingo card.",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "3. Complete all slots to unlock your reward.",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "4. Once your card is full, tap “Redeem” to claim your discount or special offer.",
                        color = Color.Black,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Terms & Conditions:",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 14.sp
                    )

                    Text(
                        text = "- Only valid purchases contribute to the Bingo card.",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Rewards may vary per shop and are subject to availability.",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "The Full Bingo Challenge resets after redemption.",
                        color = Color.Black,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Start your Full Bingo Challenge today and enjoy exclusive perks as you dine",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowBingoGuide() {
    BingoGuide(rememberNavController())
}