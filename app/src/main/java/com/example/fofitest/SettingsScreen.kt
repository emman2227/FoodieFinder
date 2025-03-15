package com.example.fofitest

import android.graphics.drawable.Icon
import androidx.compose.animation.core.rememberInfiniteTransition
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsScreen (navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                "Settings",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Profile",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 40.dp)
                    .align((Alignment.Start))
            )
            //Profile
            Box(
                modifier = Modifier
                    .width(320.dp)
                    .padding(12.dp)
                    .shadow(elevation = 20.dp, // Increase elevation for a stronger shadow
                    shape = RoundedCornerShape(5.dp),
                    ambientColor = Color.Black.copy(alpha = 0.3f), // General shadow color
                    spotColor = Color.Black.copy(alpha = 0.5f) // Stronger shadow at bottom
                    )
                    .background(Color(0xFFF5F5F5))
                    .border(0.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .clip(RoundedCornerShape(5.dp))
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("account_screen")
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.user_icon),
                        contentDescription = "",
                        tint = Color.Gray,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Profile", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.next_arrow),
                        contentDescription = "",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Account Settings",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 40.dp)
            )
            Box(
                modifier = Modifier
                    .width(320.dp)
                    .padding(12.dp)
                    .shadow(elevation = 20.dp, // Increase elevation for a stronger shadow
                        shape = RoundedCornerShape(5.dp),
                        ambientColor = Color.Black.copy(alpha = 0.3f), // General shadow color
                        spotColor = Color.Black.copy(alpha = 0.5f) // Stronger shadow at bottom
                    )
                    .background(Color(0xFFF5F5F5))
                    .border(0.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .clip(RoundedCornerShape(5.dp))
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .clickable {
                                navController.navigate("screen_ChangeProfile")
                            }
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.user_icon),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(18.dp)

                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Change Profile Picture", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.next_arrow),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .clickable { navController.navigate("screen_ChangeUsername") }
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(
                            painter = painterResource(id = R.drawable.user_icon),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Change Username", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.next_arrow),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .clickable {
                                navController.navigate("screen_ChangeEmail")
                            }
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.email_icon),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Change email address", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.next_arrow),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .clickable {
                                navController.navigate("screen_ChangePass")
                            }
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.key_icon),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Change password", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.next_arrow),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .width(320.dp)
                    .padding(12.dp)
                    .shadow(elevation = 20.dp, // Increase elevation for a stronger shadow
                        shape = RoundedCornerShape(5.dp),
                        ambientColor = Color.Black.copy(alpha = 0.3f), // General shadow color
                        spotColor = Color.Black.copy(alpha = 0.5f) // Stronger shadow at bottom
                    )
                    .background(Color(0xFFF5F5F5))
                    .border(0.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .clip(RoundedCornerShape(5.dp))
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {  },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logout_icon),
                        contentDescription = "",
                        tint = Color.Gray,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Logout", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f)
                    )

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ShowSettingsScreen (){
    SettingsScreen(navController = rememberNavController())
}