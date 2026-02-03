package com.example.disaster.presentation.report

import android.location.Location
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.example.disaster.R
import com.example.disaster.data.model.ReportFormData
import com.example.disaster.presentation.core.component.AppIconButton
import com.example.disaster.presentation.core.component.ThreeImagePicker
import com.example.disaster.presentation.util.LocationManager
import com.example.disaster.presentation.util.getAddressFromLocation
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun AddReportScreen(
    navController: NavController, onSubmit: (ReportFormData) -> Unit
) {

    var state by remember { mutableStateOf(ReportFormData()) }

//    location start

    var locationName by remember {
        mutableStateOf<String?>(null)
    }

    val context = LocalContext.current

    val locationManager = remember {
        LocationManager(
            context = context,
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(
                context
            )
        )
    }

    val locationPermissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    var location by remember {
        mutableStateOf<Location?>(null)
    }

    val coroutineScope = rememberCoroutineScope()

//    location end


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {}, navigationIcon = {
                    AppIconButton(
                        icon = painterResource(R.drawable.ic_arrow_back),
                        onClick = { navController.popBackStack() })
                }, modifier = Modifier.padding(start = 18.dp)
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


            // Contact Number
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

            // Address
            item {
                OutlinedTextField(
                    value = state.address, onValueChange = {
                        state = state.copy(address = it)
                    }, label = { Text("Address") }, modifier = Modifier.fillMaxWidth()
                )
            }

            // Description
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

            // Image Picker Section
            item {
                Column {
                    Text(
                        text = "Photos (Max 3)", style = MaterialTheme.typography.titleMedium
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

            // get location
            item {
                Column {
                    Text(
                        text = "Location", style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFFF5F5F5),
                        border = CardDefaults.outlinedCardBorder()
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = Color(0xFF0091FF)
                            )

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 12.dp)
                            ) {
                                location?.let {
                                    Text(
                                        text = if (it.latitude != null) "${it.latitude}, ${it.longitude}"
                                        else "Fetching location...",

                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Text(
                                    text = "Coordinates captured automatically",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.Gray
                                )
                            }

                            IconButton(onClick = {
                                if (!locationPermissions.allPermissionsGranted || locationPermissions.shouldShowRationale) {
                                    locationPermissions.launchMultiplePermissionRequest()
                                } else {
                                    coroutineScope.launch {
                                        location = locationManager.getLocation()

                                        location?.let {
                                            locationName = getAddressFromLocation(
                                                context,
                                                it.latitude,
                                                it.longitude
                                            )
                                        }
                                    }
                                }
                            }) {
                                Icon(Icons.Default.Refresh, contentDescription = "Refresh GPS")
                            }
                        }
                    }
                }
            }

            // Submit Button
            item {
                Button(
                    onClick = { onSubmit(state) }, modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Submit Report")
                }
            }
        }


    }


}


