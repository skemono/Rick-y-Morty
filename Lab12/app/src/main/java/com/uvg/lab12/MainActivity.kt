package com.uvg.lab12

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.uvg.lab12.ui.theme.Lab12Theme
import kotlinx.serialization.Serializable

@Serializable data object LoginDestination
@Serializable data object CharTreeDestination
@Serializable data object LocTreeDestination
@Serializable data object CharacterScreenDestination
@Serializable data class CharacterDescriptionDestination(val id: Int)
@Serializable data object LocationScreenDestination
@Serializable data class LocationDescriptionDestination(val id: Int)
@Serializable data object ProfileScreenDestination

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab12Theme {
                println("init nav controller")
                val navController = rememberNavController()
                val menuItems = listOf(
                    Triple("Characters", CharacterScreenDestination, Icons.Default.Person),
                    Triple("Locations", LocationScreenDestination, Icons.Default.Place),
                    Triple("Profile", ProfileScreenDestination, Icons.Default.AccountCircle)
                )
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                var loggedIn by rememberSaveable {
                    mutableStateOf(false)
                }
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    when (loggedIn){
                        true -> NavigationBar {
                            menuItems.forEachIndexed { index, triple ->
                                NavigationBarItem(
                                    selected = selectedItemIndex == index,
                                    label = {Text(text = triple.first)},
                                    onClick = {
                                        selectedItemIndex = index
                                        navController.navigate(triple.second)
                                    },
                                    icon = {
                                        Icon(imageVector = triple.third, contentDescription = "NavItemIcon")
                                    })
                            }
                        }
                        else -> {}
                    }
                }) { innerPadding ->
                    NavHost(navController = navController, startDestination = LoginDestination){
                        composable<LoginDestination> {
                            LoginScreen(
                                modifier = Modifier.padding(innerPadding),
                                onLoginSuccess = {
                                    navController.navigate(route = CharTreeDestination)
                                    loggedIn = true
                                }
                            )
                        }
                        composable<ProfileScreenDestination> {
                            ProfileScreen(
                                onBack = {
                                    navController.navigate(route = LoginDestination)
                                    navController.popBackStack(route = CharTreeDestination, inclusive = false)
                                    loggedIn = false
                                }
                            )
                        }
                        navigation<CharTreeDestination>(startDestination = CharacterScreenDestination){
                            composable<CharacterScreenDestination>{
                                CharacterListRoute(
                                    onCharacterClick = {id: Int -> navController.navigate(CharacterDescriptionDestination(id = id))}
                                )
                            }
                            composable<CharacterDescriptionDestination>{
                                val charArgDescDest = it.toRoute<CharacterDescriptionDestination>()
                                CharacterDetailRoute(
                                    onBack = {navController.navigateUp()},
                                    characterId = charArgDescDest.id
                                )
                            }
                        }
                        navigation<LocTreeDestination>(startDestination = LocationScreenDestination){
                            composable<LocationScreenDestination>{
                                LocationListRoute(
                                    onLocationClick = {id: Int -> navController.navigate(LocationDescriptionDestination(id = id))}
                                )
                            }
                            composable<LocationDescriptionDestination>{
                                val locationArgDescDest = it.toRoute<LocationDescriptionDestination>()
                                LocationDetailRoute(
                                    onBack = {navController.navigateUp()},
                                    locationId = locationArgDescDest.id
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


