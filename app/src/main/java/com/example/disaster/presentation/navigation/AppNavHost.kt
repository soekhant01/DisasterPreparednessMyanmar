package com.example.disaster.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.disaster.presentation.home.HomeScreen
import com.example.disaster.presentation.organization.OrganizationScreen
import com.example.disaster.presentation.preparedness.DisasterPreparednessDetail
import com.example.disaster.presentation.preparedness.SeeAllScreen
import com.example.disaster.presentation.profile.ProfileScreen
import com.example.disaster.presentation.report.ReportScreen

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
            HomeScreen(navController = navController)
        }

        composable(
            route = BottomNavItem.Organization.route
        ) {
            OrganizationScreen(navController = navController)
        }

        composable(
            route = BottomNavItem.Report.route
        ) {

            ReportScreen(navController = navController)
        }

        composable(
            route = "profile"
        ) {
            ProfileScreen(navController = navController)
        }


        composable("disaster/{type}") { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type")
            DisasterPreparednessDetail(
                type,
                navController = navController
            )
        }

        composable(
            ScreenRoute.SeeAll.route
        ) {
            SeeAllScreen(navController = navController)
        }


    }
}