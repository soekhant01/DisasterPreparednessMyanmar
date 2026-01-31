package com.example.disaster.data.model

import androidx.compose.ui.graphics.painter.Painter
import com.example.disaster.R

data class Emergency(
    val title: String,
    val icon: Int,
    )


val emergencyList = listOf(
    Emergency("Ambulance", R.drawable.ic_ambulance),
    Emergency("Hospital", R.drawable.ic_hospital),
    Emergency("Police", R.drawable.ic_police),
    Emergency("FireFighter", R.drawable.ic_fire_fighter)

)