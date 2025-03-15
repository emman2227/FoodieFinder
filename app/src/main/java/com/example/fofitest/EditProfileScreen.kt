package com.example.fofitest

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun EditProfileScreen(navController: NavController) {

}

@Preview(showBackground = true)
@Composable
fun ShowEditProfileScreen () {
    EditProfileScreen(navController = rememberNavController())
}