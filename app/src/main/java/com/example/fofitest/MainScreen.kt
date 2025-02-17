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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent { destination ->
                scope.launch { drawerState.close() }
                if (destination == "main_screen") {
                    if (navController.currentBackStackEntry?.destination?.route != "main_screen") {
                        navController.navigate("main_screen") {
                            popUpTo(navController.graph.startDestinationId) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                } else {
                    navController.navigate(destination) {
                        launchSingleTop = true
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Hamburger Menu")
                        }
                    }
                )
            },
            content = { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    NavHost(
                        navController = navController,
                        startDestination = "main_screen"
                    ) {
                        composable("main_screen") { MainContent() }
                        composable("favorites_Screen") { FavoritesScreen(navController) }
                        composable("settings_Screen") { SettingsScreen(navController) }
                        composable("account_Screen") { AccountScreen(navController) }
                    }
                }
            }
        )
    }
}


@Composable
fun MainContent() {
    var selectedCategory by rememberSaveable { mutableStateOf("popular_content") }


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
            "popular_content" -> PopularContent()
            "fast_food_content" -> FastFoodContent()
            "snacks_content" -> SnacksContent()
            "beverage_content" -> BeverageContent()
        }
    }
}


@Composable
fun LogoContainer() {
    Column(
        modifier = Modifier
            .width(325.dp)
            .height(180.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
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
            fontSize = 16.sp, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .width(350.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                item {
                    CategoryItem(
                        label = "Popular",
                        isSelected = selectedCategory == "popular_content",
                        onClick = {
                            selectedCategory = "popular_content"
                            onCategoryClick("popular_content")
                        }
                    )
                }
                item {
                    CategoryItem(
                        label = "Fast Food",
                        isSelected = selectedCategory == "fast_food_content",
                        onClick = {
                            selectedCategory = "fast_food_content"
                            onCategoryClick("fast_food_content")
                        }
                    )
                }
                item {
                    CategoryItem(
                        label = "Snacks",
                        isSelected = selectedCategory == "snacks_content",
                        onClick = {
                            selectedCategory = "snacks_content"
                            onCategoryClick("snacks_content")
                        }
                    )
                }
                item {
                    CategoryItem(
                        label = "Beverage",
                        isSelected = selectedCategory == "beverage_content",
                        onClick = {
                            selectedCategory = "beverage_content"
                            onCategoryClick("beverage_content")
                        }
                    )
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
fun DrawerContent(onItemClick: (String) -> Unit) {
    var selectedItem by remember { mutableStateOf("main_screen") }


    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxHeight()
            .width(200.dp)
            .padding(16.dp)
    ) {
        DrawerItem(
            label = "Home",
            icon = Icons.Default.Home,
            isSelected = selectedItem == "main_screen"
        ) {
            selectedItem = "main_screen"
            onItemClick("main_screen")
        }


        DrawerItem(
            label = "Favorites",
            icon = Icons.Default.FavoriteBorder,
            isSelected = selectedItem == "favorites_screen"
        ) {
            selectedItem = "favorites_screen"
            onItemClick("favorites_screen")
        }


        DrawerItem(
            label = "Settings",
            icon = Icons.Default.Settings,
            isSelected = selectedItem == "settings_screen"
        ) {
            selectedItem = "settings_screen"
            onItemClick("settings_screen")
        }


        DrawerItem(
            label = "Account",
            icon = Icons.Default.AccountCircle,
            isSelected = selectedItem == "account_screen"
        ) {
            selectedItem = "account_screen"
            onItemClick("account_screen")
        }
    }
}


@Composable
fun DrawerItem(label: String, icon: ImageVector, isSelected: Boolean, onClick: () -> Unit) {
    NavigationDrawerItem(
        label = { Text(label) },
        onClick = onClick,
        icon = { Icon(icon, contentDescription = label) },
        selected = isSelected,
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = colorResource(id = R.color.fofi_orange)
        )
    )
}




@Composable
fun PopularContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()), // Enables scrolling
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Shop()
            Spacer(modifier = Modifier.height(20.dp))
            Shop()
            Spacer(modifier = Modifier.height(20.dp))
            Shop()
            Spacer(modifier = Modifier.height(20.dp))
            Shop()
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}




@Composable
fun FastFoodContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Fast Food Content")
    }
}


@Composable
fun SnacksContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Snacks Content")
    }
}


@Composable
fun BeverageContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Content")
    }
}


@Preview(showBackground = true)
@Composable
fun ShowMainScreen() {
    MainScreen(navController = rememberNavController())
}



