package com.example.disaster.presentation.core.component

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.disaster.presentation.core.createImageUri

@Composable
fun ThreeImagePicker(
    images: List<Uri>, onImagesChange: (List<Uri>) -> Unit
) {

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var tempCameraUri by remember { mutableStateOf<Uri?>(null) }

    val cameraLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            // Copy the delegated property to a local val
            val uri = tempCameraUri
            if (uri != null) {
                onImagesChange((images + uri).take(3))
            }
        }
    }


    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
//        val updateImages = (images + uris).distinct().take(3)
//        onImagesChange(updateImages)


        uri?.let {
            onImagesChange((images + it).take(3))
        }

    }

    Column() {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            repeat(3) { index ->

                ImagePickerBox(
                    uri = images.getOrNull(index), onClick = {
                        if (images.size < 3) {
                            showDialog = true
                        }
                    })

            }

        }

        ImageSourceDialog(show = showDialog, onDismiss = { showDialog = false }, onCamera = {
            val uri = createImageUri(context)  // local non-nullable val
            tempCameraUri = uri                 // save in state
            cameraLauncher.launch(uri)  // launch safely
        }, onGallery = {
            galleryLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        })


    }


}