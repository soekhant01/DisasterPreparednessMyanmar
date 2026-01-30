package com.example.disaster.data.model

import androidx.compose.ui.res.painterResource
import com.example.disaster.R

data class Report(
    val userName: String,
    val date: String,
    val address: String,
    val coordinates: String,
    val description: String,
    val imageResIds: List<Int>
)

val reportList = listOf(
    Report(
        userName = "Soe Khant", date = "Fri, Jan 31, 2026",
        address = "Mandalay, 26str, 88 * 86 road, Aung Myay Thar Zan",
        coordinates = "21.982602, 96.085792",
        description = "An earthquake is a sudden shaking of the ground caused by the movement of tectonic plates beneath the Earth's surface. It can vary in intensity, from minor tremors that are barely felt to major quakes that cause widespread destruction. Buildings, bridges, and roads can collapse, leading to injuries or fatalities. Earthquakes may also trigger secondary disasters such as landslides, tsunamis, or fires. People in affected areas should evacuate unsafe structures, follow emergency guidelines, and seek help from local authorities immediately.",
        imageResIds = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    ),


    Report(
        userName = "Thae Phyu Soe", date = "Fri, Jan 31, 2026",
        address = "Mandalay, 26str, 88 * 86 road, Aung Myay Thar Zan",
        coordinates = "21.982602, 96.085792",
        description = "An earthquake is a sudden shaking of the ground caused by the movement of tectonic plates beneath the Earth's surface. It can vary in intensity, from minor tremors that are barely felt to major quakes that cause widespread destruction. Buildings, bridges, and roads can collapse, leading to injuries or fatalities. Earthquakes may also trigger secondary disasters such as landslides, tsunamis, or fires. People in affected areas should evacuate unsafe structures, follow emergency guidelines, and seek help from local authorities immediately.",
        imageResIds = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    ),

    Report(
        userName = "Ye Zaw Hlaing", date = "Fri, Jan 31, 2026",
        address = "Mandalay, 26str, 88 * 86 road, Aung Myay Thar Zan",
        coordinates = "21.982602, 96.085792",
        description = "An earthquake is a sudden shaking of the ground caused by the movement of tectonic plates beneath the Earth's surface. It can vary in intensity, from minor tremors that are barely felt to major quakes that cause widespread destruction. Buildings, bridges, and roads can collapse, leading to injuries or fatalities. Earthquakes may also trigger secondary disasters such as landslides, tsunamis, or fires. People in affected areas should evacuate unsafe structures, follow emergency guidelines, and seek help from local authorities immediately.",
        imageResIds = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    ),

    Report(
        userName = "Aung Thaw", date = "Fri, Jan 31, 2026",
        address = "Mandalay, 26str, 88 * 86 road, Aung Myay Thar Zan",
        coordinates = "21.982602, 96.085792",
        description = "An earthquake is a sudden shaking of the ground caused by the movement of tectonic plates beneath the Earth's surface. It can vary in intensity, from minor tremors that are barely felt to major quakes that cause widespread destruction. Buildings, bridges, and roads can collapse, leading to injuries or fatalities. Earthquakes may also trigger secondary disasters such as landslides, tsunamis, or fires. People in affected areas should evacuate unsafe structures, follow emergency guidelines, and seek help from local authorities immediately.",
        imageResIds = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    ),

    Report(
        userName = "Zin Min Thet", date = "Fri, Jan 31, 2026",
        address = "Mandalay, 26str, 88 * 86 road, Aung Myay Thar Zan",
        coordinates = "21.982602, 96.085792",
        description = "An earthquake is a sudden shaking of the ground caused by the movement of tectonic plates beneath the Earth's surface. It can vary in intensity, from minor tremors that are barely felt to major quakes that cause widespread destruction. Buildings, bridges, and roads can collapse, leading to injuries or fatalities. Earthquakes may also trigger secondary disasters such as landslides, tsunamis, or fires. People in affected areas should evacuate unsafe structures, follow emergency guidelines, and seek help from local authorities immediately.",
        imageResIds = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    ),

    Report(
        userName = "Lin Zaw Aung", date = "Fri, Jan 31, 2026",
        address = "Mandalay, 26str, 88 * 86 road, Aung Myay Thar Zan",
        coordinates = "21.982602, 96.085792",
        description = "An earthquake is a sudden shaking of the ground caused by the movement of tectonic plates beneath the Earth's surface. It can vary in intensity, from minor tremors that are barely felt to major quakes that cause widespread destruction. Buildings, bridges, and roads can collapse, leading to injuries or fatalities. Earthquakes may also trigger secondary disasters such as landslides, tsunamis, or fires. People in affected areas should evacuate unsafe structures, follow emergency guidelines, and seek help from local authorities immediately.",
        imageResIds = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    ),

    Report(
        userName = "Kyaw Than", date = "Fri, Jan 31, 2026",
        address = "Mandalay, 26str, 88 * 86 road, Aung Myay Thar Zan",
        coordinates = "21.982602, 96.085792",
        description = "An earthquake is a sudden shaking of the ground caused by the movement of tectonic plates beneath the Earth's surface. It can vary in intensity, from minor tremors that are barely felt to major quakes that cause widespread destruction. Buildings, bridges, and roads can collapse, leading to injuries or fatalities. Earthquakes may also trigger secondary disasters such as landslides, tsunamis, or fires. People in affected areas should evacuate unsafe structures, follow emergency guidelines, and seek help from local authorities immediately.",
        imageResIds = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    ),
)
