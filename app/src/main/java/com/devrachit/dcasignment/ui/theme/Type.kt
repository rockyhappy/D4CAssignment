package com.devrachit.dcasignment.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import com.devrachit.dcasignment.R
import com.devrachit.dcasignment.utility.compose_utility.ssp

// Set of Material typography styles to start with
val Typography = Typography()

val DefaultTextStyle = TextStyle(
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    ),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

// Century Old Style Typography Functions
@Composable
fun TextStyleCentury12Lh16Fw700(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 12.ssp,
        lineHeight = 16.ssp,
        fontFamily = FontFamily(Font(R.font.century_old_style_std_bold)),
        fontWeight = FontWeight(700),
    )
}

@Composable
fun TextStyleCentury14Lh18Fw700(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 14.ssp,
        lineHeight = 18.ssp,
        fontFamily = FontFamily(Font(R.font.century_old_style_std_bold)),
        fontWeight = FontWeight(700),
    )
}

@Composable
fun TextStyleCentury16Lh20Fw700(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 16.ssp,
        lineHeight = 20.ssp,
        fontFamily = FontFamily(Font(R.font.century_old_style_std_bold)),
        fontWeight = FontWeight(700),
    )
}

@Composable
fun TextStyleCentury18Lh24Fw700(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 18.ssp,
        lineHeight = 24.ssp,
        fontFamily = FontFamily(Font(R.font.century_old_style_std_bold)),
        fontWeight = FontWeight(700),
    )
}
@Composable
fun TextStyleCentury24Lh36Fw700(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 24.ssp,
        lineHeight = 36.ssp,
        fontFamily = FontFamily(Font(R.font.century_old_style_std_bold)),
        fontWeight = FontWeight(700),
    )
}
@Composable
fun TextStyleCentury28Lh40Fw700(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 28.ssp,
        lineHeight = 40.ssp,
        fontFamily = FontFamily(Font(R.font.century_old_style_std_bold)),
        fontWeight = FontWeight(700),
    )
}

// Neuzeit Book Typography Functions
@Composable
fun TextStyleNeuzeit10Lh12Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 10.ssp,
        lineHeight = 12.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeit12Lh16Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 12.ssp,
        lineHeight = 16.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeit14Lh18Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 14.ssp,
        lineHeight = 18.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeit14Lh16Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 14.ssp,
        lineHeight = 16.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(400),
    )
}
@Composable
fun TextStyleNeuzeit14Lh16Fw600(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 14.ssp,
        lineHeight = 16.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(600),
    )
}

@Composable
fun TextStyleNeuzeit16Lh20Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 16.ssp,
        lineHeight = 20.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeit18Lh24Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 18.ssp,
        lineHeight = 24.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeit20Lh26Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 20.ssp,
        lineHeight = 26.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeit24Lh30Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 24.ssp,
        lineHeight = 30.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeit24Lh40Fw700(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 24.ssp,
        lineHeight = 40.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(700),
    )
}

@Composable
fun TextStyleNeuzeit28Lh36Fw700(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 28.ssp,
        lineHeight = 36.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsbook)),
        fontWeight = FontWeight(700),
    )
}

// Neuzeitsl Std Book Typography Functions
@Composable
fun TextStyleNeuzeitsl10Lh12Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 10.ssp,
        lineHeight = 12.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsltstdbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeitsl12Lh16Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 12.ssp,
        lineHeight = 16.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsltstdbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeitsl14Lh18Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 14.ssp,
        lineHeight = 18.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsltstdbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeitsl14Lh16Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 14.ssp,
        lineHeight = 16.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsltstdbook)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleNeuzeitsl16Lh20Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 16.ssp,
        lineHeight = 20.ssp,
        fontFamily = FontFamily(Font(R.font.neuzeitsltstdbook)),
        fontWeight = FontWeight(400),
    )
}

// Tangerine Typography Functions (Decorative font)
@Composable
fun TextStyleTangerine16Lh20Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 16.ssp,
        lineHeight = 20.ssp,
        fontFamily = FontFamily(Font(R.font.tangerine)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleTangerine18Lh24Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 18.ssp,
        lineHeight = 24.ssp,
        fontFamily = FontFamily(Font(R.font.tangerine)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleTangerine20Lh26Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 20.ssp,
        lineHeight = 26.ssp,
        fontFamily = FontFamily(Font(R.font.tangerine)),
        fontWeight = FontWeight(400),
    )
}

@Composable
fun TextStyleTangerine24Lh30Fw400(): TextStyle {
    return DefaultTextStyle.copy(
        fontSize = 24.ssp,
        lineHeight = 30.ssp,
        fontFamily = FontFamily(Font(R.font.tangerine)),
        fontWeight = FontWeight(400),
    )
}
