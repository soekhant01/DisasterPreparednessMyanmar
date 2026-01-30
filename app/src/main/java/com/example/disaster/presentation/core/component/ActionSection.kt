package com.example.disaster.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.disaster.R

@Composable
fun ActionSection(modifier: Modifier = Modifier) {


//            Action section
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {

        // Section title
        Text(
            text = "Action",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        ProfileSectionRow(
            icon = painterResource(R.drawable.ic_logout),
            text = "Logout"
        )



        ProfileSectionRow(
            icon = painterResource(R.drawable.ic_delete),
            text = "Delete Account",
            isDestructive = true
        )


    }
}