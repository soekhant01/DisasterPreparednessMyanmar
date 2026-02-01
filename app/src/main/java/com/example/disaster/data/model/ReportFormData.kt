package com.example.disaster.data.model

import android.net.Uri


data class ReportFormData(
    val contactNumber: String = "",
    val address: String = "",
    val description: String = "",
    val images: List<Uri> = emptyList()
)
