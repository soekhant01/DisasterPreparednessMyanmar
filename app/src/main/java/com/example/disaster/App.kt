package com.example.disaster

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.disaster.presentation.navigation.AppNavHost
import com.example.disaster.presentation.navigation.BottomNavItem
import com.example.disaster.presentation.navigation.BottomNavigationBar

@Composable
fun App(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Only show bottom nav on these routes
    val bottomNavRoutes = setOf(
        BottomNavItem.Home.route,
        BottomNavItem.Organization.route,
        BottomNavItem.Report.route
    )

    val showBottomBar = currentRoute in bottomNavRoutes


    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { paddingValues ->

        AppNavHost(
            navController = navController,
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.White)
        )

    }
}
