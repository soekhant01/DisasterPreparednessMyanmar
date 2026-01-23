package com.example.disaster.presentation.auth.otp

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disaster.presentation.component.AppFilledButton

@Composable
fun OTPScreen() {
    var otp by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(100.dp))
        Text(
            text = "Email verification", fontSize = 24.sp, fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = "We just sent you 5 digits code via \n your email example@gmail.com",
            color = Color(0xFFA0A0A0)

        )
        Spacer(Modifier.height(24.dp))


        Text(
            text = "Enter your OTP code", color = Color(0xFFA0A0A0)

        )
        Spacer(Modifier.height(24.dp))

        OtpInput(
            numberCharacter = 5,
            shape = RoundedCornerShape(6.dp),
        ) {
            otp = it
        }
        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Didn’t receive code? "
            )
            Text(
                modifier = Modifier.clickable {},
                text = "Resend Again",
                color = Color(0xFF008955)
            )
        }
        Spacer(Modifier.height(30.dp))

        Spacer(Modifier.weight(1f))

        AppFilledButton(
            "Confirm",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp),

            )
        Spacer(Modifier.height(100.dp))

    }
}

@Composable
fun OtpInput(
    modifier: Modifier = Modifier, numberCharacter: Int, shape: Shape, onDone: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(start = 50.dp, end = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val otpState = rememberTextFieldState()
        BasicTextField(
            state = otpState,
            modifier = Modifier.semantics {
                contentType = ContentType.SmsOtpCode
            },
            inputTransformation = InputTransformation.maxLength(numberCharacter),
            lineLimits = TextFieldLineLimits.SingleLine,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            decorator = {
                val otp = otpState.text.toString()
                onDone(otp)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(numberCharacter) { index ->

                        OtpCharacter(
                            shape = shape,
                            char = otp.getOrElse(index) { ' ' },
                            focus = index == otp.length
                        )

                    }
                }
            }


        )
    }
}

@Composable
fun OtpCharacter(
    modifier: Modifier = Modifier, char: Char, focus: Boolean, shape: Shape
) {

    val boxStroke by animateDpAsState(
        targetValue = if (focus) 2.5.dp else 1.5.dp
    )

    val colorStroke by animateColorAsState(
        targetValue = if (focus) Color.Green.copy(0.8f) else Color.LightGray.copy(0.8f)
    )
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(shape)
            .border(boxStroke, colorStroke, shape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = char.toString(), fontWeight = FontWeight.SemiBold, color = Color.Black
        )

    }
}
