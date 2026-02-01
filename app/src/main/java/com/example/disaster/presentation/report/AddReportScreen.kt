package com.example.disaster.presentation.report

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.disaster.R
import com.example.disaster.data.model.ReportFormData
import com.example.disaster.presentation.core.component.AppIconButton
import com.example.disaster.presentation.core.component.ThreeImagePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddReportScreen(
    navController: NavController,
    onSubmit: (ReportFormData) -> Unit
) {

    var state by remember { mutableStateOf(ReportFormData()) }



    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
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
                .padding(16.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {


            // 📞 Contact Number
            item {
                OutlinedTextField(
                    value = state.contactNumber,
                    onValueChange = {
                        state = state.copy(contactNumber = it)
                    },
                    label = { Text("Contact Number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // 📍 Address
            item {
                OutlinedTextField(
                    value = state.address,
                    onValueChange = {
                        state = state.copy(address = it)
                    },
                    label = { Text("Address") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // 📝 Description
            item {
                OutlinedTextField(
                    value = state.description,
                    onValueChange = {
                        state = state.copy(description = it)
                    },
                    label = { Text("Description") },
                    minLines = 4,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // 🖼️ Image Picker Section
            item {
                Column {
                    Text(
                        text = "Photos (Max 3)",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    ThreeImagePicker(
                        images = state.images,
                        onImagesChange = {
                            state = state.copy(images = it)
                        },
                    )
                }
            }

            // Submit Button
            item {
                Button(
                    onClick = { onSubmit(state) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Submit Report")
                }
            }
        }


    }


}


