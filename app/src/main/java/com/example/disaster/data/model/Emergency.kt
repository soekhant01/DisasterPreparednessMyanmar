package com.example.disaster.data.model

import androidx.compose.ui.graphics.painter.Painter
import com.example.disaster.R

data class Emergency(
    val title: String,
    val icon: Int,
    val phoneNumber: String
    )


val emergencyList = listOf(
    Emergency("Ambulance", R.drawable.ic_ambulance, "09957848184"),
    Emergency("Hospital", R.drawable.ic_hospital, "09957848184"),
    Emergency("Police", R.drawable.ic_police, "09957848184"),
    Emergency("FireFighter", R.drawable.ic_fire_fighter, "09957848184")

)