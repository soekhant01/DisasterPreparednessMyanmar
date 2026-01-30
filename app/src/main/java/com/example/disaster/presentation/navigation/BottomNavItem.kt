package com.example.disaster.presentation.navigation

import android.graphics.drawable.Icon
import com.example.disaster.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Home: BottomNavItem("home","Home",R.drawable.ic_home)
    object Organization: BottomNavItem("organization", "Organization", R.drawable.ic_organization)
    object Report: BottomNavItem("report", "Report", R.drawable.ic_report)

}