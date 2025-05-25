package com.devrachit.dcasignment.presentation.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.devrachit.dcasignment.R
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit12Lh16Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit16Lh20Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit24Lh40Fw700
import com.devrachit.dcasignment.utility.compose_utility.sdp

data class BannerData(
    val title: String,
    val subtitle: String,
    val dateRange: String
)

@Composable
fun PromoBanner() {
    val bannerItems = listOf(
        BannerData("GET 20% OFF", "Get 20% Off", "12-16 October"),
        BannerData("FREE DELIVERY", "Free Shipping", "17-20 October"),
        BannerData("BUY 1 GET 1", "Special Offer", "21-25 October")
    )
    
    val pagerState = rememberPagerState(pageCount = { 3 })
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 10.sdp, start = 10.sdp, end = 10.sdp)
    ) {
        // Static background image
        Image(
            painter = painterResource(id = R.drawable.banner_card),
            contentDescription = "Banner Background",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth
        )
        
        // Pager content
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            val currentBanner = bannerItems[page]
            
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.sdp, vertical = 30.sdp)
                ) {
                    Text(
                        text = currentBanner.title,
                        style = TextStyleNeuzeit24Lh40Fw700(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.padding(vertical = 0.sdp))
                    
                    Text(
                        text = currentBanner.subtitle,
                        style = TextStyleNeuzeit16Lh20Fw400(),
                        color = Color.White.copy(alpha = 0.7f),
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.padding(vertical = 5.sdp))
                    
                    Text(
                        text = currentBanner.dateRange,
                        style = TextStyleNeuzeit12Lh16Fw400(),
                        color = Color.Black.copy(alpha = 0.9f),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.sdp))
                            .background(colorResource(R.color.primary_color))
                            .padding(horizontal = 12.sdp, vertical = 4.sdp)
                    )
                }
                
                Image(
                    painter = painterResource(id = R.drawable.ic_scene),
                    contentDescription = "Scene Icon",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 40.sdp, bottom = 40.sdp)
                        .size(70.sdp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                )
            }
        }
        
        // Page indicator
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(bottom = 5.sdp),
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.fillMaxWidth(0.15f))
            
            Row(
                modifier = Modifier.fillMaxWidth(0.35f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .width(20.sdp)
                            .height(5.sdp)
                            .clip(RoundedCornerShape(2.sdp))
                            .background(
                                if (index == pagerState.currentPage) {
                                    colorResource(R.color.primary_color)
                                } else {
                                    Color.Gray.copy(alpha = 0.5f)
                                }
                            )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PromoBannerPreview() {
    PromoBanner()
}
