package com.nutribalance.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nutribalance.R

private val Inter = FontFamily(
    Font(R.font.inter_black, FontWeight.Black),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
    Font(R.font.inter_extralight, FontWeight.ExtraLight),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_thin, FontWeight.Thin),
)

private val Notosans = FontFamily(
    Font(R.font.notosans_black, FontWeight.Black),
    Font(R.font.notosans_bold, FontWeight.Bold),
    Font(R.font.notosans_extrabold, FontWeight.ExtraBold),
    Font(R.font.notosans_extralight, FontWeight.ExtraLight),
    Font(R.font.notosans_light, FontWeight.Light),
    Font(R.font.notosans_medium, FontWeight.Medium),
    Font(R.font.notosans_regular, FontWeight.Normal),
    Font(R.font.notosans_thin, FontWeight.Thin),
)

val baseline = Typography()

val Typography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = Inter),
    displayMedium = baseline.displayMedium.copy(fontFamily = Inter),
    displaySmall = baseline.displaySmall.copy(fontFamily = Inter),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = Inter),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = Inter),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = Inter),
    titleLarge = baseline.titleLarge.copy(fontFamily = Inter),
    titleMedium = baseline.titleMedium.copy(fontFamily = Inter),
    titleSmall = baseline.titleSmall.copy(fontFamily = Inter),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = Notosans),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = Notosans),
    bodySmall = baseline.bodySmall.copy(fontFamily = Notosans),
    labelLarge = baseline.labelLarge.copy(fontFamily = Notosans),
    labelMedium = baseline.labelMedium.copy(fontFamily = Notosans),
    labelSmall = baseline.labelSmall.copy(fontFamily = Notosans),
)