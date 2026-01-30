package com.example.disaster.presentation.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disaster.R
import com.example.disaster.data.model.Report
import okhttp3.Address

@Composable
fun ReportCard(
    modifier: Modifier = Modifier,
    report: Report,
    maxLines: Int = 3

) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    val displayLines = if (isExpanded) Int.MAX_VALUE else maxLines

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

//            card header
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE0E0E0)),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painter = painterResource(R.drawable.ic_profile),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(40.dp)
                    )


                }
                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = report.userName,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        color = Color.Black
                    )

                    Text(
                        text = report.date,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = report.address,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                fontSize = 16.sp
            )
//
//            Text(
//                text = report.coordinates,
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    color = Color(0xFF42A5F5),
//                    fontWeight = FontWeight.Medium
//                ),
//                modifier = Modifier.padding(vertical = 4.dp)
//            )
            Text(
                text = report.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                lineHeight = 20.sp,
                maxLines = displayLines,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = if (isExpanded) "see less" else "...see more",
                color = Color(0xFF42A5F5),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable(
                        indication = null, // removes ripple
                    interactionSource = remember { MutableInteractionSource() }
                ) { isExpanded = !isExpanded }
            )


//            photo section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
//                left photo
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painterResource(R.drawable.img1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))

                Column(
                    modifier = Modifier.weight(0.8f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.LightGray)
                    ) {
                        Image(
                            painterResource(R.drawable.img2),
                            contentDescription = null,
                            contentScale = ContentScale.Crop

                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.LightGray)
                    ) {
                        Image(
                            painterResource(R.drawable.img3),
                            contentDescription = null,
                            contentScale = ContentScale.Crop

                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Accept Button
            Button(
                onClick = { /* Handle Accept */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0091FF))
            ) {
                Text(text = "See On Map", fontSize = 18.sp, color = Color.White)
            }
        }

    }
}