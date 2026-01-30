package com.example.disaster.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.disaster.R
import com.example.disaster.presentation.core.component.AppIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navController: NavController) {

    val scrollState = rememberScrollState()

    val noPaddingTextStyle = TextStyle(
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    )

    Scaffold(
        containerColor = Color.White,

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Text(
                        "Profile",
                    )
                },
                navigationIcon = {
                    AppIconButton(
                        modifier = Modifier.padding(start = 16.dp),
                        icon = painterResource(R.drawable.ic_arrow_back),
                        onClick = { navController.navigate("home") })
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_edit), contentDescription = null
                        )
                    }
                },
            )
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {

//            profile pic, name, and email
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFF2F2F2)), // avatar background
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_profile),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(Modifier.height(16.dp))

                Text(
                    text = "Soe Khant",
                    style = noPaddingTextStyle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(4.dp))

                Text(
                    text = "soekhant.dev@gmail.com",
                    style = noPaddingTextStyle,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            Spacer(Modifier.height(16.dp))



            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp)
            ) {

                // Section title
                Text(
                    text = "Account",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // My Account row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {}
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_account),
                            contentDescription = "My Account",
                            tint = Color.Gray
                        )

                        Spacer(modifier = Modifier.width(12.dp))


                        Text(
                            text = "My Account",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Icon(
                        painter = painterResource(R.drawable.ic_right_arrow),
                        contentDescription = "Go to My Account",
                        tint = Color.Gray
                    )
                }


            }

            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))


//                help & support
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp)
            ) {

                // Section title
                Text(
                    text = "Support & About",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // help and support row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {}
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_help),
                            contentDescription = "Go to Support",
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Help & Support",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                    }


                    Icon(
                        painter = painterResource(R.drawable.ic_right_arrow),
                        contentDescription = "Go to Support",
                        tint = Color.Gray
                    )
                }
//                        about app row

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {}
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically) {


                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Icon(
                            painter = painterResource(R.drawable.ic_about),
                            contentDescription = "about",
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "About",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )

                    }


                    Icon(
                        painter = painterResource(R.drawable.ic_right_arrow),
                        contentDescription = "Go to about",
                        tint = Color.Gray
                    )
                }

            }
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))


//            Action
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp)
            ) {

                // Section title
                Text(
                    text = "Action",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 12.dp)
                )


                // Logout
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {}
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically) {


                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.ic_logout),
                            contentDescription = "logout",
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Logout",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                    }


                    Icon(
                        painter = painterResource(R.drawable.ic_right_arrow),
                        contentDescription = "logout",
                        tint = Color.Gray
                    )
                }
//                        delete account row

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {}
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically) {


                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Icon(
                            painter = painterResource(R.drawable.ic_delete),
                            contentDescription = "Go to My Account",
                            tint = Color.Gray
                        )

                        Spacer(modifier = Modifier.width(12.dp))


                        Text(
                            text = "Delete Account",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )

                    }

                    Icon(
                        painter = painterResource(R.drawable.ic_right_arrow),
                        contentDescription = "Go to My Account",
                        tint = Color.Gray
                    )
                }


            }
        }

    }

}

