package com.example.disaster.presentation.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp


@Composable
fun RadioButtonSingleSelection(
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = Modifier
            .fillMaxWidth().padding(start = 4.dp, end = 4.dp)
            .height(56.dp)
            .selectable(
                selected = (text == selectedOption),
                role = Role.RadioButton,
                onClick = { onOptionSelected(text) }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween


    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )

        RadioButton(
            selected = (text == selectedOption),
            onClick = null // null recommended for accessibility with screen readers
        )
    }
}