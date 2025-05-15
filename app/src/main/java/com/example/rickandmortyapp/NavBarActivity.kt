package com.example.rickandmortyapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.rickandmortyapp.data.model.CharacterModel
import com.example.rickandmortyapp.pages.characters_description_page.CharacterDetailScreen
import com.example.rickandmortyapp.pages.characters_page.CharactersPage
import com.example.rickandmortyapp.pages.episodes_page.EpisodesPage
import com.example.rickandmortyapp.pages.favs_page.FavsPage
import com.example.rickandmortyapp.pages.location_page.LocationsPage
import com.example.rickandmortyapp.ui.theme.Color1
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.google.gson.Gson
import java.net.URLDecoder

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Karakterler", "characters", Icons.Default.Face),
        BottomNavItem("Favoriler", "favorites", Icons.Default.Search),
        BottomNavItem("Konumlar", "locations", Icons.Default.LocationOn),
        BottomNavItem("Bölümler", "episodes", Icons.Default.Menu)
    )

    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            if (currentRoute != item.route) {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color1,
                            selectedTextColor = Color1
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "characters",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("characters") { CharactersPage(navController) }
            composable("favorites") { FavsPage(navController) }
            composable("locations") { LocationsPage() }
            composable("episodes") { EpisodesPage() }

            // Ek sayfa örneği (detay)
            composable("characterDetail/{characterModel}", arguments = listOf(
                navArgument("characterModel"){type=NavType.StringType},
            )) {
                val jsonCharacterModelData=it.arguments?.getString("characterModel")
                val decoded = URLDecoder.decode(jsonCharacterModelData, "UTF-8")
                val characterModel = Gson().fromJson(decoded, CharacterModel::class.java)
                CharacterDetailScreen(navController,characterModel)
            }
        }
    }
}

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun PreviewNavBar() {
    RickAndMortyAppTheme {

    }
}

