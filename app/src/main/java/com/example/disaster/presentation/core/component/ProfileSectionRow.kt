package com.example.disaster.presentation.core.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.disaster.R

@Composable
fun ProfileSectionRow(
    modifier: Modifier = Modifier,
    icon: Painter,
    text: String,
    isDestructive: Boolean = false,
    isForwarded: Boolean = false,
    onClick: () -> Unit = {}
) {


    val contentColor = if (isDestructive) Color.Red else Color.Gray
    val textColor = if (isDestructive) Color.Red else MaterialTheme.colorScheme.onSurface

    // My Account row
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically) {

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                painter = icon,
                contentDescription = text,
                tint = contentColor
            )

            Spacer(modifier = Modifier.width(12.dp))


            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f),
                color = textColor
            )
        }

        if (isForwarded) {
            Icon(
                painter = painterResource(R.drawable.ic_right_arrow),
                contentDescription = text,
                tint = Color.Gray
            )
        }
    }
}