package com.example.disaster.presentation.core.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.disaster.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    onQueryUpdate: (newvalue: String) -> Unit,
) {
    var isSearchExpanded by rememberSaveable { mutableStateOf(false) }
    val searchBarPadding by animateDpAsState(
        targetValue = if (isSearchExpanded) 0.dp else 16.dp
    )

    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(searchBarPadding),
        shape = CircleShape,
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.primary.copy(.5f),
            dividerColor = Color.Unspecified
        ),
        inputField = {
            SearchBarDefaults.InputField(
                query = "",
                onQueryChange = {},          // no-op
                onSearch = {},               // no-op
                expanded = false,
                onExpandedChange = { },       // no-op
                placeholder = {
                    Text("Search")
                },
                leadingIcon = {
                    IconButton(
                        onClick = {
//                            if (isSearchExpanded) {
//                                onQueryUpdate("")
//                            }
//                            isSearchExpanded = !isSearchExpanded
                        },

                    ) {
                        val icon =
                            if (isSearchExpanded) painterResource(R.drawable.ic_arrow_back) else painterResource(
                                R.drawable.ic_search
                            )

                        Icon(
                            painter = icon,
                            contentDescription = null
                        )
                    }
                },
                trailingIcon = null,         // optional
                colors = SearchBarDefaults.inputFieldColors()
            )
        },
        expanded = isSearchExpanded,
        onExpandedChange = { isExpanded -> isSearchExpanded = isExpanded },
    ) {}


}