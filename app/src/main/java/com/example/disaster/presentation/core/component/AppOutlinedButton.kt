package com.example.disaster.presentation.core.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppOutlinedButton(
    buttonLabel: String,
    iconPainter: Painter? = null,
    modifier: Modifier = Modifier
) {

    OutlinedButton(onClick = { }, modifier = modifier, shape = RoundedCornerShape(12.dp)) {


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (iconPainter != null) {
                Icon(
                    painter = iconPainter,
                    null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp) ,
                )
            }

            Spacer(Modifier.width(4.dp))
            Text(buttonLabel, fontSize = 16.sp, modifier = Modifier.padding(8.dp))

        }


    }
}