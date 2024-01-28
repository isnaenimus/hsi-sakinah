package com.dicoding.hsisakinah.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicoding.hsisakinah.screens.HomeScreen
import com.dicoding.hsisakinah.screens.ProfileScreen
import com.dicoding.hsisakinah.screens.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                val selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                listOfBottomNavItem.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                tint = if (index == selectedItemIndex) {
                                    Color.Blue
                                } else Color.Black,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = navItem.label,
                                color = if (index == selectedItemIndex) {
                                    Color.Blue
                                } else Color.Black,
                                fontSize = 9.sp
                            )
                        },
                        alwaysShowLabel = true,
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.HomeScreen.name) {
                HomeScreen()
            }
            composable(Screens.SearchScreen.name) {
                SearchScreen()
            }
            composable(Screens.ProfileScreen.name) {
                ProfileScreen()
            }
        }
    }
}