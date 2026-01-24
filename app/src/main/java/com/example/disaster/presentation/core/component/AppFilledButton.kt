package com.example.disaster.presentation.core.component

import android.R.attr.onClick
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppFilledButton(buttonLabel: String, modifier: Modifier = Modifier) {

    Button(onClick = { }, modifier = modifier, shape = RoundedCornerShape(12.dp)) {
        Text(buttonLabel, fontSize = 16.sp, modifier = Modifier.padding(8.dp))
    }
}