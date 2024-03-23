package com.dicoding.hsisakinah.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicoding.hsisakinah.screens.HomeScreen
import com.dicoding.hsisakinah.screens.PartnerListShow
import com.dicoding.hsisakinah.screens.ProfileScreen
import com.dicoding.hsisakinah.screens.SearchScreen
import com.dicoding.hsisakinah.ui.theme.HsiSakinahTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar {
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                listOfBottomNavItem.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(navItem.route)
                        },
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                tint = if (index == selectedItemIndex) {
                                    MaterialTheme.colorScheme.primary
                                } else MaterialTheme.colorScheme.secondary,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = navItem.label,
                                color = if (index == selectedItemIndex) {
                                    MaterialTheme.colorScheme.primary
                                } else MaterialTheme.colorScheme.secondary,
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