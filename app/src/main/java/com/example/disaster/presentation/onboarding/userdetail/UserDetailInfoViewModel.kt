package com.example.disaster.presentation.onboarding.userdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserDetailInfoViewModel : ViewModel() {

    var fullName by mutableStateOf("")
        private set
    var phNumber by mutableStateOf("")
        private set

    var nrcNumber by mutableStateOf("")
        private set

    var selectedRegion by mutableStateOf("")
        private set



    fun onFullNameChange(name: String) {
        fullName = name
    }

    fun onPhoneNumberChange(phoneNumber: String) {
        phNumber = phoneNumber
    }

    fun onNrcNumberChange(nrcNum: String){
        nrcNumber = nrcNum
    }

    fun onRegionSelected(region: String) {
        selectedRegion = region
    }
}