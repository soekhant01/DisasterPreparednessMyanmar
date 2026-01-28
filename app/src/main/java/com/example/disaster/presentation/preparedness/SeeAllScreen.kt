package com.example.disaster.presentation.preparedness

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.disaster.R
import com.example.disaster.data.model.disasterList
import com.example.disaster.presentation.core.component.AppIconButton
import com.example.disaster.presentation.core.component.DisasterCard
import com.example.disaster.presentation.navigation.ScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeeAllScreen(modifier: Modifier = Modifier, navController: NavController) {


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
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(disasterList) { disaster ->
                DisasterCard(disaster = disaster, onClick = {
                    navController.navigate("disaster/${disaster.route}")
                }, modifier = Modifier.fillMaxWidth())
            }
        }

    }

}