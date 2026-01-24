package com.example.disaster.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.disaster.presentation.home.HomeScreen
import com.example.disaster.presentation.organization.OrganizationScreen
import com.example.disaster.presentation.profile.ProfileScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    )
    {
        composable(
            route = BottomNavItem.Home.route
        ) {
            HomeScreen()
        }

        composable(
            route = BottomNavItem.Organization.route
        ) {
            OrganizationScreen()
        }

        composable(
            route = BottomNavItem.Profile.route
        ) {
            ProfileScreen()
        }

    }
}