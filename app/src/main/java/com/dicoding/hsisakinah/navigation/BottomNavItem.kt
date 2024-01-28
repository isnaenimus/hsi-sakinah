package com.dicoding.hsisakinah.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
)

val listOfBottomNavItem = listOf(
    BottomNavItem(
        Screens.HomeScreen.name,
        Icons.Outlined.Home,
        "Home"
    ),
    BottomNavItem(
        Screens.SearchScreen.name,
        Icons.Outlined.Search,
        "Pencarian"
    ),
    BottomNavItem(
        Screens.ProfileScreen.name,
        Icons.Outlined.Person,
        "Profil"
    )
)
