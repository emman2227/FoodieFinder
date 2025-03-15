package com.example.fofitest


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Shop() {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp)) // Rounded corners apply to entire Box
            .border(0.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp) // Allocates proper space for image
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) // Apply rounding
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sampleimg),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp) // Ensures text area stays within the box
                    .background(Color.White)
                    .padding(start = 15.dp, top = 8.dp)
            ) {
                Column {
                    Text(
                        text = "Shop Name",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Short Location",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ShowShop() {
    Shop()
}

