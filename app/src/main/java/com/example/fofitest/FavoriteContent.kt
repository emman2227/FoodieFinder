package com.example.fofitest

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier

@Composable
fun FavoriteContent(navController: NavController) {
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(5.dp))
            .border(0.5.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
            .background(color = Color.White)
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

                // Box to position the close icon at the upper right
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .padding(4.dp) // Add padding to prevent touching the edge
                        .align(Alignment.TopEnd)
                ) {
                    IconButton(
                        onClick = { /* Handle remove action */ },
                        modifier = Modifier
                            .size(12.dp)
                            .background(Color.Red, shape = CircleShape) // Red circular button
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close, // Close (X) icon
                            contentDescription = "Remove",
                            tint = Color.White
                        )
                    }
                }
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


@Preview (showBackground = true)
@Composable
fun ShowFavoriteContent() {
    FavoriteContent(rememberNavController())
}