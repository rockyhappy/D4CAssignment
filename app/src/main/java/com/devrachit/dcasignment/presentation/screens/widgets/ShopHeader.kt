package com.devrachit.dcasignment.presentation.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.devrachit.dcasignment.R
import com.devrachit.dcasignment.ui.theme.TextStyleCentury28Lh40Fw700
import com.devrachit.dcasignment.utility.compose_utility.sdp

@Composable
fun ShopHeader(
    searchCount: Int = 0,
    favoriteCount: Int = 0,
    cartCount: Int = 0,
    onSearchClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {},
    onCartClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .padding(start = 30.sdp, top = 20.sdp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "Shop",
            style = TextStyleCentury28Lh40Fw700(),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .padding(end = 20.sdp),
            horizontalArrangement = Arrangement.spacedBy(15.sdp)
        ) {
            CountableIcons(
                count = searchCount,
                onClick = onSearchClick
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(30.sdp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                )
            }
            CountableIcons(
                count = favoriteCount,
                onClick = onFavoriteClick
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = "Favorite Icon",
                    modifier = Modifier.size(28.sdp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                )
            }
            CountableIcons(
                count = cartCount,
                onClick = onCartClick
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_cart_outlined),
                    contentDescription = "Cart Icon",
                    modifier = Modifier.size(28.sdp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopHeaderPreview() {
    ShopHeader(
        searchCount = 0,
        favoriteCount = 5,
        cartCount = 3
    )
}
