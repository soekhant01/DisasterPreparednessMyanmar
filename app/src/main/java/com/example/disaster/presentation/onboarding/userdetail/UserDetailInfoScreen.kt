package com.example.disaster.presentation.onboarding.userdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.disaster.R
import com.example.disaster.presentation.core.component.AppFilledButton
import com.example.disaster.presentation.core.component.AppIconButton
import com.example.disaster.presentation.core.component.AppTextField
import com.example.disaster.presentation.core.component.DatePickerDocked
import com.example.disaster.presentation.core.component.RegionDropDown

@Composable
fun UserDetailInfoScreen(modifier: Modifier = Modifier, viewModel: UserDetailInfoViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 0.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {

        AppIconButton(icon = painterResource(R.drawable.ic_arrow_back))

        Spacer(Modifier.height(24.dp))


        Text(
            "Your Info",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(Modifier.height(24.dp))


        AppTextField(
            "Enter Your FullName",
            value = viewModel.fullName,
            onValueChange = viewModel::onFullNameChange,
            label = "FullName",
        )

        Spacer(Modifier.height(24.dp))


        AppTextField(
            "Phone Number",
            value = viewModel.phNumber,
            onValueChange = viewModel::onPhoneNumberChange,
            label = "phone number",
        )

        Spacer(Modifier.height(24.dp))

        Text(
            "Select Your Region/State",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        RegionDropDown(
            value = viewModel.selectedRegion,
            onSelected = viewModel::onRegionSelected
        )

        Spacer(Modifier.height(24.dp))

        Text(
            "Select Your Date of birth",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        DatePickerDocked()

        Spacer(Modifier.height(24.dp))



        AppFilledButton(
            "Next",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))


    }

}