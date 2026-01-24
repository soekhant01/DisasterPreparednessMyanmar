package com.example.disaster.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disaster.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Scaffold(
        containerColor = Color.White,
        topBar = {
            HomeTopBar("Soe Khant", {})
        }) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) { }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    userName: String, onNotificationClick: () -> Unit, modifier: Modifier = Modifier
) {


    val noPaddingTextStyle = TextStyle(
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    )

    TopAppBar(
        title = {
        Row(

            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF2F2F2)), // avatar background
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(Modifier.width(4.dp))
            Column(
            ) {
                Text(
                    text = "Hi Welcome 👋",
                    style = noPaddingTextStyle,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = userName,
                    style = noPaddingTextStyle,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }, actions = {
        IconButton(
            onClick = onNotificationClick
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_notifications),
                contentDescription = null
            )
        }

    }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.White
    )

    )

}