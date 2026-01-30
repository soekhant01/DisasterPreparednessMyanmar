package com.example.disaster.presentation.report

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.disaster.data.model.reportList
import com.example.disaster.presentation.core.component.AppSearchBar
import com.example.disaster.presentation.core.component.ReportCard

@Composable
fun ReportScreen(modifier: Modifier = Modifier) {

    Scaffold(
        containerColor = Color.White,

        topBar = {
            AppSearchBar(
                onQueryUpdate = {}
            )
        }

    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(
                top = 16.dp,
                bottom = innerPadding.calculateBottomPadding() + 64.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(reportList) { report ->
                ReportCard(report = report)

            }
        }
    }
}