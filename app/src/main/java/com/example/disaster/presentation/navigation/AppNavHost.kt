package com.example.disaster.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.disaster.presentation.core.component.OpenStreetMapView
import com.example.disaster.presentation.home.HomeScreen
import com.example.disaster.presentation.organization.OrganizationScreen
import com.example.disaster.presentation.preparedness.DisasterPreparednessDetail
import com.example.disaster.presentation.preparedness.SeeAllScreen
import com.example.disaster.presentation.profile.MyAccountScreen
import com.example.disaster.presentation.profile.ProfileScreen
import com.example.disaster.presentation.report.AddReportScreen
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

        navigation(
            route = BottomNavItem.Report.route,
            startDestination = ReportRoute.List.route
        ) {
            composable(ReportRoute.List.route) {
                ReportScreen(
                    navController = navController
                )
            }

            composable(
                ReportRoute.Map.route, arguments = listOf(
                    navArgument("latitude") { type = NavType.FloatType },
                    navArgument("longitude") { type = NavType.FloatType },

                    )
            ) { backStackEntry ->
                val latitude = backStackEntry.arguments?.getFloat("latitude") ?: 0f
                val longitude = backStackEntry.arguments?.getFloat("longitude") ?: 0f
                OpenStreetMapView(
                    latitude = latitude.toDouble(),
                    longitude = longitude.toDouble(),
                )
            }
        }


        navigation(
            route = "profile",
            startDestination = "profile/home"
        ) {
            composable(
                route = "profile/home"
            ) {
                ProfileScreen(navController = navController)
            }

            composable("profile/account") {
                MyAccountScreen(navController = navController)
            }

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

        composable(
            route = "add_report"
        ) {
            AddReportScreen(
                navController = navController,
                onSubmit = {}
            )
        }


    }
}