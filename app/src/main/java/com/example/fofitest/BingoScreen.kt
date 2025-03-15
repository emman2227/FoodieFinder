package com.example.fofitest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BingoCard(navController: NavController) {
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
            // navigation Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Back Button
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .clip(RoundedCornerShape(50))
                            .background(colorResource(id = R.color.fofi_orange))
                            .padding(8.dp)
                            .clickable {
                                navController.navigate("screen_ShopContent")
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "Back Button",
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    // more info
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .clip(RoundedCornerShape(50))
                            .background(colorResource(id = R.color.fofi_orange))
                            .padding(8.dp)
                            .clickable { navController.navigate("screen_BingoGuide") }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.question_icon),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(50.dp))

            // Bingo Card Container
            Box(
                modifier = Modifier
                    .height(450.dp)
                    .width(340.dp)
                    .background(color = Color(0xFFFAA96C), shape = RoundedCornerShape(16.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    // Bingo Image at the Top Center
                    Image(
                        painter = painterResource(R.drawable.bingo),
                        contentDescription = "",
                        modifier = Modifier
                            .height(100.dp)
                            .width(250.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.weight(1f)) // Pushes tiles to the bottom

                    // Bingo Tiles
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        BingoTile1()
                        BingoTile2()
                        BingoTile3()
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        BingoTile4()
                        BingoTile5()
                        BingoTile6()
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        BingoTile7()
                        BingoTile8()
                        BingoTile9()
                    }
                }
            }
        }
    }
}



@Composable
fun BingoTile1() { TilePlaceholder() }
@Composable
fun BingoTile2() { TilePlaceholder() }
@Composable
fun BingoTile3() { TilePlaceholder() }
@Composable
fun BingoTile4() { TilePlaceholder() }
@Composable
fun BingoTile5() { TilePlaceholder() }
@Composable
fun BingoTile6() { TilePlaceholder() }
@Composable
fun BingoTile7() { TilePlaceholder() }
@Composable
fun BingoTile8() { TilePlaceholder() }
@Composable
fun BingoTile9() { TilePlaceholder() }

@Composable
fun TilePlaceholder() {
    Surface(
        modifier = Modifier
            .size(100.dp)
            .padding(4.dp),
        color = Color.White ,
        shape = RoundedCornerShape(8.dp)
    ) {
       // wala pa
    }
}

@Preview
@Composable
fun PreviewBingoCard() {
    BingoCard(rememberNavController())
}