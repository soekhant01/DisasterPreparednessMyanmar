package com.example.disaster.presentation.core.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.disaster.R
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun DatePickerDocked(modifier: Modifier = Modifier) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Column() {

        Text(
            "Select Your Date of birth", fontWeight = FontWeight.Bold, fontSize = 18.sp
        )



        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedDate,
                onValueChange = {},
                label = { Text("DOB") },
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = !showDatePicker }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_date),
                            contentDescription = "Select date"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            )
            if (showDatePicker) {
                Popup(
                    onDismissRequest = { showDatePicker = false }, alignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .width(450.dp)
                            .height(450.dp)

                            .shadow(elevation = 4.dp)
                    ) {
                        androidx.compose.material3.DatePicker(
                            state = datePickerState, showModeToggle = false
                        )
                    }
                }
            }

        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}