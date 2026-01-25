package com.example.disaster.presentation.core.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disaster.presentation.core.constants.Nrc

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegionNrc(
    modifier: Modifier,
    selectedRegionCode: String,
    onRegionSelected: (String) -> Unit

) {


    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }


    OutlinedButton(
        modifier = modifier,
        onClick = { showBottomSheet = true },
        shape = RoundedCornerShape(4.dp), // Rounded corners
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor =  MaterialTheme.colorScheme.onSurface
        )
    ) {
        Text(
            text = if (selectedRegionCode.isEmpty()) "Please Select" else selectedRegionCode,
            fontSize = 10.sp
        )
    }

    if (showBottomSheet) {

        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
        ) {
            // Use a LazyColumn for better performance with long lists
            LazyColumn {

                items(Nrc.ALL_REGIONS_AND_STATES_NUMBER.size) { index ->
                    val regionCode = Nrc.ALL_REGIONS_AND_STATES_NUMBER[index]

                    RadioButtonSingleSelection(
                        text = regionCode,
                        selectedOption = selectedRegionCode, // Pass the current state
                        onOptionSelected = {
                            onRegionSelected(it)
                            showBottomSheet = false          // Close the sheet
                        }
                    )
                }
            }
        }
    }

}

