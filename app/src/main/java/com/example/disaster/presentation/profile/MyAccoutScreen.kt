package com.example.disaster.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.disaster.R
import com.example.disaster.data.model.Address
import com.example.disaster.data.model.UserInfoData
import com.example.disaster.presentation.core.component.AccountAddressCard
import com.example.disaster.presentation.core.component.AccountInfoCard
import com.example.disaster.presentation.core.component.AppIconButton
import com.example.disaster.presentation.core.component.ProfileHeaderSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAccountScreen(modifier: Modifier = Modifier, navController: NavController) {

    val accountInfo = UserInfoData(
        fullName = "Soe Khant",
        nrc = "12/ABC(N)123456",
        contact = "09-123456789",
        dob = "1999-05-12",
        gender = "Male",
        socialUrl = "https://facebook.com/soekhant",
        address = Address(
            city = "Yangon",
            township = "Hlaing",
            road = "Pyay Road",
            street = "Insein Road",
            latitude = 16.8409,
            longitude = 96.1735
        )

    )


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("My Account")
                },
                navigationIcon = {
                    AppIconButton(
                        icon = painterResource(R.drawable.ic_arrow_back),
                        onClick = { navController.popBackStack() }

                    )
                },
                modifier = Modifier.padding(start = 18.dp)
            )
        }

    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {


//            profile header
            item { ProfileHeaderSection() }

            item { Modifier.height(16.dp) }

            item {
                AccountInfoCard(
                    accountInfo = accountInfo
                )
            }

            item {
                AccountAddressCard(
                    location = accountInfo
                )
            }

            item {
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text("My Location")
                }
            }


        }

    }
}