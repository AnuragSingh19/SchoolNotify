package com.cy.schoolnotify.comon_utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.cy.schoolnotify.ui.theme.SNTypography

@Composable
fun HeadTitleTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.titleLarge.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun HeadTitleTextWithSemiBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.titleLarge.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    )
}

@Composable
fun TitleMediumTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun TitleMediumTextWithSemiBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.titleMedium.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    )
}

@Composable
fun TitleSmallTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.titleSmall.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun TitleSmallTextWithSemiBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.titleSmall.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    )
}

@Composable
fun LabelLargeTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelLarge.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun LabelLargeTextWithSemiBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelLarge.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    )
}

@Composable
fun LabelLargeTextWithMediumFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelLarge.copy(
            fontWeight = FontWeight.Medium,
            color = color
        )
    )
}

@Composable
fun LabelLargeTextWithRegularFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelLarge.copy(
            fontWeight = FontWeight.Normal,
            color = color
        )
    )
}

@Composable
fun LabelMediumTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelMedium.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun LabelMediumTextWithSemiBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelMedium.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    )
}

@Composable
fun LabelMediumTextWithMediumFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelMedium.copy(
            fontWeight = FontWeight.Medium,
            color = color
        )
    )
}

@Composable
fun LabelMediumTextWithRegularFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelMedium.copy(
            fontWeight = FontWeight.Normal,
            color = color
        )
    )
}

@Composable
fun LabelSmallTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelSmall.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun LabelSmallTextWithSemiBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelSmall.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    )
}

@Composable
fun LabelSmallTextWithMediumFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelSmall.copy(
            fontWeight = FontWeight.Medium,
            color = color
        )
    )
}

@Composable
fun LabelSmallTextWithRegularFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.labelSmall.copy(
            fontWeight = FontWeight.Normal,
            color = color
        )
    )
}


@Composable
fun BodyLargeTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodyLarge.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun BodyLargeTextWithSemiBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodyLarge.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    )
}

@Composable
fun BodyLargeTextWithMediumFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodyLarge.copy(
            fontWeight = FontWeight.Medium,
            color = color
        )
    )
}

@Composable
fun BodyLargTextWithRegularFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodyLarge.copy(
            fontWeight = FontWeight.Normal,
            color = color
        )
    )
}

@Composable
fun BodyMediumTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodyMedium.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun BodyMediumTextWithSemiBoldFont(
    value: String,
    color: Color,
    modifier: Modifier = Modifier,
    textAlign: TextAlign
) {
    Text(
        text = value, style = SNTypography.bodyMedium.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        ),
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun BodyMediumTextWithMediumFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodyMedium.copy(
            fontWeight = FontWeight.Medium,
            color = color
        )
    )
}

@Composable
fun BodyMediumTextWithRegularFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodyMedium.copy(
            fontWeight = FontWeight.Normal,
            color = color
        )
    )
}


@Composable
fun BodySmallTextWithBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodySmall.copy(
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun BodySmallTextWithSemiBoldFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodySmall.copy(
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    )
}

@Composable
fun BodySmallTextWithMediumFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodySmall.copy(
            fontWeight = FontWeight.Medium,
            color = color
        )
    )
}

@Composable
fun BodySmallTextWithRegularFont(value: String, color: Color) {
    Text(
        text = value, style = SNTypography.bodySmall.copy(
            fontWeight = FontWeight.Normal,
            color = color
        )
    )
}
