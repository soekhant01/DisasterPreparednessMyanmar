package com.example.disaster.presentation.core.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CitizenNrc(modifier: Modifier = Modifier) {

    OutlinedButton(
        modifier = modifier,
        onClick = { },
        shape = RoundedCornerShape(4.dp), // Rounded corners
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onSurface
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor =  MaterialTheme.colorScheme.onSurface
        )
    ) {
        Text(
            text = "N",
            fontSize = 12.sp
        )
    }

}