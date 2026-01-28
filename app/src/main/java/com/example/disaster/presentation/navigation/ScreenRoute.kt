package com.example.disaster.presentation.navigation

sealed class ScreenRoute(val route: String) {
    object SeeAll : ScreenRoute("see_all")

}