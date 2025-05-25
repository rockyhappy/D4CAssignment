package com.devrachit.dcasignment.presentation.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devrachit.dcasignment.R

@Composable
fun CountableIcons(
    count: Int,
    onClick: () -> Unit = {},
    icon: @Composable () -> Unit
){
    BadgedBox(
        badge = {
            if (count > 0) {
                Badge(
                    containerColor = colorResource(id = R.color.primary_color),
                ) {
                    Text(
                        text = if (count > 99) "99+" else count.toString(),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
        modifier = Modifier.clickable { onClick() }
    ) {
        icon()
    }
}

@Preview(showBackground = true)
@Composable
fun CountableIconsPreview() {
    MaterialTheme {
        CountableIcons(
            count = 5,
            icon = {
                Image(
                    painter = painterResource(id = android.R.drawable.ic_dialog_email),
                    contentDescription = "Email Icon",
                    modifier = Modifier.size(48.dp)
                )
            }
        )
    }
}
