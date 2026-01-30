package com.example.disaster.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier, navController: NavHostController) {

    val bottomNavItem = listOf(
        BottomNavItem.Home, BottomNavItem.Organization, BottomNavItem.Report
    )

    NavigationBar(containerColor = Color(0xFFF4F6F8)) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


        bottomNavItem.forEach { navItem ->
            NavigationBarItem(
                selected = navItem.route == currentRoute,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = navItem.label
                    )
                },
                label = { Text(navItem.label) }
            )

        }

    }
}