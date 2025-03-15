 package com.example.fofitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fofitest.ui.theme.FoFiTestTheme

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FoFiTestTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "landing_Screen", builder ={
                    composable("screen_First") {
                        FirstScreen(navController)
                    }
                    composable("screen_Second") {
                        SecondScreen(navController)
                    }
                    composable("screen_Third") {
                        ThirdScreen(navController)
                    }
                    composable("screen_Fourth") {
                        FourthScreen(navController)
                    }
                    composable("landing_screen") {
                        LandingScreen(navController)
                    }

                    composable("screen_Login"){
                        LoginScreen(navController)
                    }
                    composable("screen_Signup"){
                        SignupScreen(navController)
                    }
                    composable("screen_Main"){
                        MainScreen(navController)
                    }
                    composable("screen_Favorites"){
                        FavoritesScreen(navController)
                    }
                    composable("screen_Account"){
                        AccountScreen(navController)
                    }
                    composable("screen_Settings"){
                        SettingsScreen(navController)
                    }
                    composable("screen_Forgot-password"){
                        ForgotPasswordScreen(navController)
                    }
                } )
            }
        }
    }
}
