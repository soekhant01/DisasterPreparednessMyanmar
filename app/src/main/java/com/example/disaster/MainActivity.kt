package com.example.disaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.disaster.presentation.auth.login.LoginScreen
import com.example.disaster.presentation.auth.otp.OTPScreen
import com.example.disaster.presentation.auth.register.RegisterScreen
import com.example.disaster.ui.theme.DisasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DisasterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    OTPScreen()
                }
            }
        }
    }
}
