package com.example.disaster.presentation.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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


@Composable
fun Preparedness(modifier: Modifier = Modifier, navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(disasterList) { disaster ->
            DisasterCard(disaster = disaster, onClick = {
                navController.navigate("disaster/${disaster.route}")
            })
        }
    }

}


