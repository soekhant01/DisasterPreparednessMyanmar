package com.example.disaster.presentation.preparedness

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.disaster.presentation.preparedness.methods.BurnScreen
import com.example.disaster.presentation.preparedness.methods.CycloneScreen
import com.example.disaster.presentation.preparedness.methods.DroughtScreen
import com.example.disaster.presentation.preparedness.methods.EarthquakeScreen
import com.example.disaster.presentation.preparedness.methods.FloodScreen
import com.example.disaster.presentation.preparedness.methods.ForestFireScreen
import com.example.disaster.presentation.preparedness.methods.LandslideScreen

@Composable
fun DisasterPreparednessDetail(type: String?, navController: NavHostController) {

    when (type) {
        "flood" -> FloodScreen(
            navController = navController
        )

        "cyclone" -> CycloneScreen(
            navController = navController

        )

        "drought" -> DroughtScreen(
            navController = navController

        )

        "earthquake" -> EarthquakeScreen(
            navController = navController

        )

        "burn" -> BurnScreen(
            navController = navController

        )

        "landslide" -> LandslideScreen(
            navController = navController

        )

        "forest_fire" -> ForestFireScreen(
            navController = navController

        )
    }
}