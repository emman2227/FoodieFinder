package com.example.fofitest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreen(navController: NavController) {

}

@Composable
fun FirstScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.w1),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
            Box(
                modifier =
                    Modifier
                        .width(250.dp)
                        .height(100.dp)
            ) {
                Text(
                    text = "Welcome to FoodieFinder, where flavor meets you!", style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50)) // Optional: Makes it rounded
                    .background(color = colorResource(id = R.color.fofi_orange).copy(alpha = 0.7f)) // Optional: Adds a semi-transparent background
                    .padding(8.dp) // Padding inside the background

            ) {
                Image(
                    painter = painterResource(id = R.drawable.next_arrow), // Your vector drawable
                    contentDescription = "Back Button",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .clickable {
                            navController.navigate("screen_Second")
                        }
                )
            }
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.w2),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
            Box(
                modifier =
                Modifier
                    .width(250.dp)
                    .height(100.dp)
            ) {
                Text(
                    text = "Cravings? We've got the perfect spot!", style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50)) // Optional: Makes it rounded
                    .background(color = colorResource(id = R.color.fofi_orange).copy(alpha = 0.7f)) // Optional: Adds a semi-transparent background
                    .padding(8.dp) // Padding inside the background

            ) {
                Image(
                    painter = painterResource(id = R.drawable.next_arrow), // Your vector drawable
                    contentDescription = "Back Button",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .clickable {
                            navController.navigate("screen_Third")
                        }
                )
            }
        }
    }
}


@Composable
fun ThirdScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.w3),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
            Box(
                modifier =
                Modifier
                    .width(250.dp)
                    .height(100.dp)
            ) {
                Text(
                    text = "Discover top food spots with FoodieFinder!", style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50)) // Optional: Makes it rounded
                    .background(color = colorResource(id = R.color.fofi_orange).copy(alpha = 0.7f)) // Optional: Adds a semi-transparent background
                    .padding(8.dp) // Padding inside the background

            ) {
                Image(
                    painter = painterResource(id = R.drawable.next_arrow), // Your vector drawable
                    contentDescription = "Back Button",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .clickable {
                            navController.navigate("screen_Fourth")
                        }
                )
            }
        }
    }
}

@Composable
fun FourthScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.w4),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Box(
                modifier =
                Modifier
                    .width(250.dp)
                    .height(100.dp)
            ) {
                Text(
                    text = "Start discovering shops now!", style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50)) // Optional: Makes it rounded
                    .background(color = colorResource(id = R.color.fofi_orange).copy(alpha = 0.7f)) // Optional: Adds a semi-transparent background
                    .padding(8.dp) // Padding inside the background

            ) {
                Image(
                    painter = painterResource(id = R.drawable.next_arrow), // Your vector drawable
                    contentDescription = "Back Button",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .clickable {
                            navController.navigate("screen_Login")
                        }
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ShowWelcomeScreen() {
    FourthScreen(rememberNavController())
}