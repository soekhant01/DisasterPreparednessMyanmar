package com.example.disaster.presentation.onboarding.userdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.disaster.R
import com.example.disaster.presentation.core.component.AppFilledButton
import com.example.disaster.presentation.core.component.AppIconButton
import com.example.disaster.presentation.core.component.AppTextField
import com.example.disaster.presentation.core.component.CitizenNrc
import com.example.disaster.presentation.core.component.DatePickerDocked
import com.example.disaster.presentation.core.component.RegionDropDown
import com.example.disaster.presentation.core.component.RegionNrc
import com.example.disaster.presentation.core.component.TownshipNRC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailInfoScreen(
    modifier: Modifier = Modifier,
    viewModel: UserDetailInfoViewModel = viewModel(),
    navController: NavController
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    AppIconButton(
                        icon = painterResource(R.drawable.ic_arrow_back),
                        onClick = { navController.navigate("home") }

                    )
                },
                modifier = Modifier.padding(start = 18.dp)
            )
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {


            Spacer(Modifier.height(8.dp))


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

            Spacer(Modifier.height(18.dp))


            AppTextField(
                "Phone Number",
                value = viewModel.phNumber,
                onValueChange = viewModel::onPhoneNumberChange,
                label = "phone number",
            )

            Spacer(Modifier.height(18.dp))


            DatePickerDocked()

            Spacer(Modifier.height(18.dp))


            Text(
                "NRC Number",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            var selectedRegionCode by rememberSaveable { mutableStateOf("") }
            var selectedTownShipCode by rememberSaveable { mutableStateOf("") }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RegionNrc(
                    modifier = Modifier.weight(1f),
                    selectedRegionCode = selectedRegionCode,
                    onRegionSelected = { region ->
                        selectedRegionCode = region
                        selectedTownShipCode = ""

                    }
                )
                TownshipNRC(
                    modifier = Modifier.weight(1f),
                    selectedRegionCode = selectedRegionCode,
                    selectedTownshipCode = selectedTownShipCode,
                    onTownshipSelected = { township ->
                        selectedTownShipCode = township
                    }
                )

                CitizenNrc()
            }
            AppTextField(
                "",
                value = viewModel.nrcNumber,
                onValueChange = { input ->
                    if (input.length <= 6 && input.all { it.isDigit() }) {
                        viewModel.onNrcNumberChange(input)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true,
                label = "Nrc Number",
            )

            Spacer(Modifier.height(18.dp))

            Text(
                "Select Your Region/State",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            RegionDropDown(
                value = viewModel.selectedRegion,
                onSelected = viewModel::onRegionSelected
            )

            Spacer(Modifier.height(18.dp))

            AppFilledButton(
                "Next",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))


        }
    }


}