package com.example.disaster.presentation.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.disaster.R
import com.example.disaster.data.model.Address
import com.example.disaster.data.model.UserInfoData

@Composable
fun AccountAddressCard(modifier: Modifier = Modifier, location: UserInfoData) {

//    val location = userInfo.address.firstOrNull() // safe first address
//    if (location == null) {
//        Text("No address available")
//        return
//    }


    Column() {

        Row(
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = null
            )
            Text(
                text = "Address",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }
        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                // City
                AccountInfoItem(
                    label = "City",
                    value = location.address.city
                )

                // Township
                AccountInfoItem(
                    label = "Township",
                    value = location.address.township
                )

                // Road
                AccountInfoItem(
                    label = "Road",
                    value = location.address.road
                )

                // Street
                AccountInfoItem(
                    label = "Street",
                    value = location.address.street
                )

            }
        }


    }
}