package com.example.disaster.presentation.core.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun TownshipNRC(
    modifier: Modifier,
    selectedRegionCode: String,
    selectedTownshipCode: String,
    onTownshipSelected: (String) -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    val isEnabled = selectedRegionCode.isNotEmpty()

    OutlinedButton(
        modifier = modifier,
        enabled = isEnabled,
        shape = RoundedCornerShape(4.dp), // Rounded corners
        border = BorderStroke(
            width = 1.dp,
            color =  MaterialTheme.colorScheme.primary
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor =  MaterialTheme.colorScheme.onSurface
        ),
        onClick = {
            if (selectedRegionCode.isNotEmpty()) {
                showSheet = true
            }
        },

        ) {
        Text(
            text = when {
                selectedTownshipCode.isNotEmpty() -> selectedTownshipCode
                else -> "Please Select"
            },
            fontSize = 10.sp

        )
    }

    if (showSheet && isEnabled) {
        val townshipList = when (selectedRegionCode) {
            "1" -> Nrc.KACHIN_TOWNSHIP_CODES
            "2" -> Nrc.KAYAH_TOWNSHIP_CODES
            "3" -> Nrc.KAYIN_TOWNSHIP_CODES
            "4" -> Nrc.CHIN_TOWNSHIP_CODES
            "5" -> Nrc.SAGAING_TOWNSHIP_CODES
            "6" -> Nrc.TANINTHARYI_TOWNSHIP_CODES
            "7" -> Nrc.BAGO_TOWNSHIP_CODES
            "8" -> Nrc.MAGWAY_TOWNSHIP_CODES
            "9" -> Nrc.MANDALAY_TOWNSHIP_CODES
            "10" -> Nrc.MON_TOWNSHIP_CODES
            "11" -> Nrc.RAKHINE_TOWNSHIP_CODES
            "12" -> Nrc.YANGON_TOWNSHIP_CODES
            "13" -> Nrc.SHAN_TOWNSHIP_CODES
            else -> Nrc.AYA_TOWNSHIP_CODES
        }
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            LazyColumn {
                items(townshipList) { township ->
                    RadioButtonSingleSelection(
                        text = township,
                        selectedOption = selectedTownshipCode,
                        onOptionSelected = {
                            onTownshipSelected(it)
                            showSheet = false
                        }
                    )
                }
            }
        }
    }
}
