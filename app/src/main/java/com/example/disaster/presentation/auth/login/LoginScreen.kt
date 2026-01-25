package com.example.disaster.presentation.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disaster.R
import com.example.disaster.presentation.core.component.AppFilledButton
import com.example.disaster.presentation.core.component.AppIconButton
import com.example.disaster.presentation.core.component.AppOutlinedButton
import com.example.disaster.presentation.core.component.AppTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var checked by rememberSaveable { mutableStateOf(false) }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    AppIconButton(
                        icon = painterResource(R.drawable.ic_arrow_back)
                    )
                },
                modifier = Modifier.padding(start = 18.dp)
            )
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {

            Spacer(Modifier.height(8.dp))



            Text(
                "Sign In",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )

            Spacer(Modifier.height(8.dp))

            Text("Welcome back! Please enter your details")

            Spacer(Modifier.height(24.dp))


            AppTextField(
                "Enter Your Email",
                value = email,
                onValueChange = { email = it },
                label = "Email",
            )

            Spacer(Modifier.height(32.dp))


            AppTextField(
                "Enter Your Password",
                value = password,
                onValueChange = { password = it },
                label = "Password",
                isPassword = true
            )


            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

//            for remember me
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )

                    Text(
                        text = "Remember Me"
                    )
                }

//            for forgot password
                TextButton(
                    onClick = {}
                ) {
                    Text("Forgot Password", color = Color.Red, fontSize = 16.sp)
                }
            }


            Spacer(Modifier.height(16.dp))


            AppFilledButton(
                "SignIn",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            AppOutlinedButton(
                buttonLabel = "Continue With Google",
                iconPainter = painterResource(R.drawable.ic_google),

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,

                ) {
                Text("Don't have an account?", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                TextButton(
                    onClick = {}
                ) {
                    Text("Sign Up", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }

        }

    }


}