package com.cy.schoolnotify.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cy.schoolnotify.R

// Set of Material typography styles to start with

val Gilroy = FontFamily(
    Font(R.font.gilroy_regular, FontWeight.Light),
    Font(R.font.gilroy_medium, FontWeight.Normal),
    Font(R.font.gilroy_semibold, FontWeight.Medium),
    Font(R.font.gilroy_bold, FontWeight.Bold)
)
private val defaultTypography = Typography()
val SNTypography = Typography(
    bodyLarge = defaultTypography.bodyLarge.copy(
        fontFamily = Gilroy,
        color = TextColor
    ),
    bodyMedium = defaultTypography.bodyMedium.copy(
        fontFamily = Gilroy,
        color = TextColor
    ),
    bodySmall = defaultTypography.bodySmall.copy(
        fontFamily = Gilroy,
        color = TextColor
    ),
    titleLarge = defaultTypography.titleLarge.copy(
        fontFamily = Gilroy,
        color = TextColor
    ),
    titleMedium = defaultTypography.titleMedium.copy(
        fontFamily = Gilroy,
        color = TextColor
    ),
    titleSmall = defaultTypography.titleSmall.copy(
        fontFamily = Gilroy,
        color = TextColor
    ),
    labelLarge = defaultTypography.labelLarge.copy(
        fontFamily = Gilroy,
        color = TextColor
    ),
    labelMedium = defaultTypography.labelMedium.copy(
        fontFamily = Gilroy,
        color = TextColor
    ),
    labelSmall = defaultTypography.labelSmall.copy(
        fontFamily = Gilroy,
        color = TextColor
    )
)