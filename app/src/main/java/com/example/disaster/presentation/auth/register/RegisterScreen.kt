package com.example.disaster.presentation.auth.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disaster.R
import com.example.disaster.presentation.component.AppFilledButton
import com.example.disaster.presentation.component.AppOutlinedButton

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    var fullName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val annotatedText = buildAnnotatedString {
        append("By signing up, you agree to our terms of ")

        withStyle(style = SpanStyle(color = Color(0xFF4CAF50), fontWeight = FontWeight.SemiBold)) {
            append("Service")
        }

        append(" and ")

        withStyle(style = SpanStyle(color = Color(0xFF4CAF50), fontWeight = FontWeight.SemiBold)) {
            append("Privacy Policy")
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(24.dp)
    ) {


        Text(
            "Sign Up",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )

        Spacer(Modifier.height(24.dp))


        RegisterField(
            "Enter Your FullName",
            value = fullName,
            onValueChange = { fullName = it },
            label = "FullName",
        )

        Spacer(Modifier.height(32.dp))


        RegisterField(
            "Enter Your Email",
            value = email,
            onValueChange = { email = it },
            label = "Email",
        )

        Spacer(Modifier.height(32.dp))


        RegisterField(
            "Enter Your Password",
            value = password,
            onValueChange = { password = it },
            label = "Password",
            isPassword = true
        )

        Spacer(Modifier.height(24.dp))


        Text(
            annotatedText,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray
        )

        Spacer(Modifier.height(24.dp))


        AppFilledButton(
            "Sign Up",
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
            Text("Already Have An Account?", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            TextButton(
                onClick = {}
            ) {
                Text("Sign In", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

    }


}


@Composable
fun RegisterField(
    text: String,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false,
    error: String? = null,
    modifier: Modifier = Modifier
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(

    ) {

        Text(
            text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(Modifier.height(4.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            visualTransformation =
                if (isPassword && !passwordVisible) PasswordVisualTransformation()
                else VisualTransformation.None,
            trailingIcon =
                {
                    if (isPassword) {
                        IconButton(onClick = {
                            passwordVisible = !passwordVisible
                        }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter =
                                    if (passwordVisible)
                                        painterResource(R.drawable.visibility)
                                    else painterResource(R.drawable.visibility_off),
                                contentDescription = null
                            )
                        }

                    } else {
                        null
                    }
                },
            isError = error != null
        )
    }

//    if (error != null) {
//        Text(
//            text = error,
//            color = MaterialTheme.colorScheme.error,
//            style = MaterialTheme.typography.bodySmall
//        )
//    }
}

@Preview
@Composable
private fun PreviewRegister() {

    RegisterScreen()
}


