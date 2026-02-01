package com.example.disaster.presentation.core.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ImageSourceDialog(
    modifier: Modifier = Modifier, show: Boolean,
    onDismiss: () -> Unit,
    onCamera: () -> Unit,
    onGallery: () -> Unit
) {

    if (!show) return

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select Image") },
        text = { Text("Choose image source") },
        confirmButton = {
            TextButton(onClick = {
                onCamera()
                onDismiss()
            }) { Text("Camera") }
        },
        dismissButton = {
            TextButton(onClick = {
                onGallery()
                onDismiss()
            }) { Text("Gallery") }
        }
    )

}