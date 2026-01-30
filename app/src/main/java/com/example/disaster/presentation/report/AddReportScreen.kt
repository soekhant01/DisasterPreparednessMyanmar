package com.example.disaster.presentation.report

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.disaster.R
import com.example.disaster.presentation.core.component.AppIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddReportScreen(modifier: Modifier = Modifier, navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    AppIconButton(
                        icon = painterResource(R.drawable.ic_arrow_back),
                        onClick = { navController.popBackStack()}
                    )
                },
                modifier = Modifier.padding(start = 18.dp)
            )
        }

    ) { innerPadding ->

        Box(modifier = Modifier.fillMaxSize().padding(innerPadding) , contentAlignment = Alignment.Center){
            Text("Add Report")
        }
    }
}