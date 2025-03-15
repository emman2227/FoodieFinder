package com.example.fofitest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun FavoritesScreen (navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "My Favorite",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                FavoriteContent(navController)
                FavoriteContent(navController)
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ShowFavoritesScreen() {
    FavoritesScreen(navController = rememberNavController())
}