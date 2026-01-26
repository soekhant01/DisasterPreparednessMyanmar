package com.example.disaster.presentation.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.disaster.R

@Composable
fun BannerCarousel(modifier: Modifier = Modifier) {

    val pageCount = Int.MAX_VALUE
    val initialPager = pageCount / 2

    val pagerState = rememberPagerState(
        initialPage = initialPager,
        pageCount = { pageCount }
    )
    val imageList = listOf(
        R.drawable.neymar,
        R.drawable.rooney,
        R.drawable.ronaldinho,
        R.drawable.debruney,
    )


    Column(
        modifier
            .defaultMinSize(minHeight = 300.dp)
            .fillMaxWidth()
            .padding(16.dp)
    ) {


        HorizontalPager(
            state = pagerState,
            pageSpacing = 20.dp,
        ) { page ->
            val pageIndex = page % imageList.size

            Image(
                painter = painterResource(id = imageList[pageIndex]),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }

}