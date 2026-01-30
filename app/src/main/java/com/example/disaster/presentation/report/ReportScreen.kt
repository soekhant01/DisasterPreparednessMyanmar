package com.example.disaster.presentation.report

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.disaster.data.model.reportList
import com.example.disaster.presentation.core.component.AppSearchBar
import com.example.disaster.presentation.core.component.FAB
import com.example.disaster.presentation.core.component.ReportCard

@Composable
fun ReportScreen(modifier: Modifier = Modifier, navController: NavController) {
    val listState = rememberLazyListState()
    var showFab by remember { mutableStateOf(true) }

    LaunchedEffect(listState) {
        snapshotFlow { listState.isScrollInProgress }
            .collect { isScrolling ->
                showFab = !isScrolling
            }
    }




    Scaffold(
        containerColor = Color.White,

        topBar = {
            AppSearchBar(
                onQueryUpdate = {}
            )
        }, floatingActionButton = {
            AnimatedVisibility(
                visible = showFab,
                enter = fadeIn() + slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth } // from right
                ),
                exit = fadeOut() + slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth } // to right
                )
            ) {
                FAB(navController)
            }

        },
        floatingActionButtonPosition = FabPosition.Center


    ) { innerPadding ->
        LazyColumn(
            state = listState,
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