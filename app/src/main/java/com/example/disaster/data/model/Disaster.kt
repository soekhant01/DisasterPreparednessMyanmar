package com.example.disaster.data.model

import com.example.disaster.R


data class Disaster(
    val name: String,
    val iconResId: Int,
    val route: String
)

val disasterList = listOf(
    Disaster("Flood", R.drawable.flood, "flood"),
    Disaster("Cyclone", R.drawable.cyclone, "cyclone"),
    Disaster("Earthquake", R.drawable.earthquake, "earthquake"),
    Disaster("Landslide", R.drawable.landslide, "landslide"),
    Disaster("Drought", R.drawable.drought, "drought"),
    Disaster("Burn", R.drawable.burn, "burn"),
    Disaster("Forest Fire", R.drawable.forest_fire, "forest_fire")

)
