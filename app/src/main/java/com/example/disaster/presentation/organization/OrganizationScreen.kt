package com.example.disaster.presentation.organization

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.disaster.data.model.organizationList
import com.example.disaster.presentation.core.component.AppSearchBar
import com.example.disaster.presentation.core.component.OrganizationCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganizationScreen(modifier: Modifier = Modifier, navController: NavController) {

    Scaffold(
        topBar = {
            AppSearchBar(
                onQueryUpdate ={}
            )
        }

    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(organizationList) { organization ->
                OrganizationCard(organization = organization)
            }

        }
    }
}