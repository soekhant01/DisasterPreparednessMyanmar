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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.disaster.R
import com.example.disaster.data.model.UserInfoData

@Composable
fun AccountInfoCard(modifier: Modifier = Modifier, accountInfo: UserInfoData) {

    Column() {

        Row(
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null
            )
            Text(
                text = "Information",
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

                AccountInfoItem(label = "FullName", value = accountInfo.fullName)
                AccountInfoItem(label = "NRC", value = accountInfo.nrc)
                AccountInfoItem(label = "Contact", value = accountInfo.contact)
                AccountInfoItem(label = "DOB", value = accountInfo.dob)
                AccountInfoItem(label = "Gender", value = accountInfo.gender)
                AccountInfoItem(label = "Social Link", value = accountInfo.socialUrl)
            }
        }


    }

}
