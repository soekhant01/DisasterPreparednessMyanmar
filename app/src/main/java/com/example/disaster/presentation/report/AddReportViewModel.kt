package com.example.disaster.presentation.report

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import com.example.disaster.data.model.ReportFormData
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddReportViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(ReportFormData())
    val uiState: StateFlow<ReportFormData> = _uiState.asStateFlow()


    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(application)


    fun onContactNumberChange(value: String) {
        _uiState.update { it.copy(contactNumber = value) }
    }

    fun onAddressChange(value: String){
        _uiState.update { it.copy(address = value) }
    }

    fun onDescriptionChange(value: String){
        _uiState.update { it.copy(description = value) }
    }

    fun onImagesChange(images: List<Uri>) {
        _uiState.update { it.copy(images = images) }
    }



}