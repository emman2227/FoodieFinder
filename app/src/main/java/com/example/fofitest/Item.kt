package com.example.fofitest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Item(navController: NavController) {
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(5.dp))
            .border(0.5.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
            .background(color = Color.White)
            .clickable {
                navController.navigate("screen_ItemContent") // Navigate to ItemContent
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp))
            ) {
                ItemImageContainer()
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(Color.White)
                    .padding(start = 8.dp, top = 10.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    ItemNameContainer()
                }
            }
        }
    }
}

@Composable
fun ItemImageContainer(){
    Image(
        painter = painterResource(id = R.drawable.sampleimg2),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ItemNameContainer() {
    Text(
        text = "Item Name",
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )
}


@Preview (showBackground = true)
@Composable
fun ShowItem() {
    Item(rememberNavController())
}