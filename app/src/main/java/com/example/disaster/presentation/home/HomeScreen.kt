package com.example.disaster.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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
import androidx.navigation.NavController
import com.example.disaster.R
import com.example.disaster.presentation.core.component.BannerCarousel
import com.example.disaster.presentation.core.component.Preparedness

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {


    Scaffold(
        containerColor = Color.White,
        topBar = {
            HomeTopBar("Soe Khant", {}, navController)
        }) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {

            BannerCarousel()


            Spacer(modifier.height(8.dp))
            Column() {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Disaster Preparedness",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    TextButton(onClick = {
                        navController.navigate("see_all")
                    }) {
                        Text(
                            "See All",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }

                Preparedness(navController = navController)
            }
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    userName: String, onNotificationClick: () -> Unit, navController: NavController
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
                        modifier = Modifier.size(24.dp).clickable{
                            navController.navigate("profile")
                        }
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
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(R.drawable.bell),
                    contentDescription = null
                )
            }

        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )

    )

}