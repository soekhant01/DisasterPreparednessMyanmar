package com.example.disaster.presentation.core.component

import androidx.compose.foundation.Image
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
import com.example.disaster.R

data class Disaster(
    val name: String,
    val iconResId: Int
)

val disasterList = listOf(
    Disaster("Flood", R.drawable.flood),
    Disaster("Cyclone", R.drawable.cyclone),
    Disaster("Earthquake", R.drawable.earthquake),
    Disaster("Landslide", R.drawable.landslide),
    Disaster("Drought", R.drawable.drought),
    Disaster("Burn", R.drawable.burn),
    Disaster("Forest Fire", R.drawable.forest_fire)

    )


@Composable
fun Preparedness(modifier: Modifier = Modifier) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(disasterList) { disaster ->
            DisasterCard(disaster = disaster)
        }
    }

}


@Composable
fun DisasterCard(disaster: Disaster) {
    Card(
        modifier = Modifier
            .width(120.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Image(
                painter = painterResource(id = disaster.iconResId),
                contentDescription = disaster.name,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = disaster.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
