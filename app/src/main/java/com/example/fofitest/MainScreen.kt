package com.example.fofitest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fofitest.ui.theme.BingoGuide

@Composable
fun MainScreen(navController: NavController) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "main_screen"
            ) {
                composable("main_screen") { MainContent(navController) }
                composable("favorites_screen") { FavoritesScreen(navController) }
                composable("screen_FavoriteContent") { FavoriteContent(navController) }
                composable("settings_screen") { SettingsScreen(navController) }
                composable("account_screen") { AccountScreen(navController) }
                composable("screen_ShopContent") { ShopContent(navController) }
                composable("screen_Bingo") { BingoCard(navController) }
                composable("screen_BingoGuide") { BingoGuide(navController) }
                composable("screen_ItemContent") { ItemContent(navController) }
                composable("screen_EditProfile") { EditProfileScreen(navController)}
                composable("screen_ChangeUsername") { ChangeUsernameScreen(navController)}
                composable("screen_ChangeProfile") { ChangeProfileScreen(navController)}
                composable("screen_ChangeEmail") { ChangeEmailScreen(navController) }
                composable("screen_ChangePass") { ChangePassScreen(navController) }

            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home, "main_screen"),
        BottomNavItem("Favorites", Icons.Default.FavoriteBorder, "favorites_screen"),
        BottomNavItem("Settings", Icons.Default.Settings, "settings_screen")
    )
    val fofiOrange = colorResource(id = R.color.fofi_orange)
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: "main_screen"

    NavigationBar(
        modifier = Modifier
            .height(55.dp),
        containerColor = Color.White
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = fofiOrange,
                    selectedTextColor = fofiOrange,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                ),
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}

data class BottomNavItem(val label: String, val icon: ImageVector, val route: String)

@Composable
fun MainContent(navController: NavController) {
    var selectedCategory by rememberSaveable { mutableStateOf("popular_content") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LogoContainer()
            Spacer(modifier = Modifier.height(15.dp))
            ShopCategories { category -> selectedCategory = category }
            Spacer(modifier = Modifier.height(15.dp))

            when (selectedCategory) {
                "popular_content" -> PopularContent(navController)
                "fast_food_content" -> FastFoodContent()
                "snacks_content" -> SnacksContent()
                "beverage_content" -> BeverageContent()
            }
        }
    }
}

@Composable
fun LogoContainer() {
    Box (
        modifier = Modifier
            .width(325.dp)
            .height(200.dp)
            .padding(top = 25.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.homepage),
            contentDescription = "Homepage",
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun ShopCategories(onCategoryClick: (String) -> Unit) {
    var selectedCategory by remember { mutableStateOf("popular_content") }

    Column(
        modifier = Modifier
            .height(75.dp)
            .padding(start = 25.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Top Categories",
            fontSize = 16.sp, fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .width(350.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp), modifier = Modifier.padding(end = 10.dp)) {
                listOf(
                    "Popular" to "popular_content",
                    "Fast Food" to "fast_food_content",
                    "Snacks" to "snacks_content",
                    "Beverage" to "beverage_content"
                ).forEach { (label, route) ->
                    item {
                        CategoryItem(
                            label = label,
                            isSelected = selectedCategory == route,
                            onClick = {
                                selectedCategory = route
                                onCategoryClick(route)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItem(label: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) colorResource(id = R.color.fofi_orange) else Color.White
    val textColor = if (isSelected) Color.White else Color.Black

    Text(
        text = label,
        modifier = Modifier
            .border(0.5.dp, Color.Black, shape = RoundedCornerShape(10.dp))
            .background(backgroundColor, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .width(75.dp)
            .clickable { onClick() },
        fontSize = 16.sp,
        color = textColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun PopularContent(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShopItem(navController)
            ShopItem(navController)
            ShopItem(navController)
        }
    }
}

@Composable
fun ShopItem(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("screen_ShopContent")
            }
            .padding(12.dp)
    ) {
        Shop()
    }
}

@Composable
fun SnacksContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Snacks Content")
    }
}

@Composable
fun FastFoodContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Fast Food Content")
    }
}

@Composable
fun BeverageContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Beverage Content")
    }
}


@Preview(showBackground = true)
@Composable
fun ShowMainScreen() {
    MainScreen(navController = rememberNavController())
}
