package com.paulyaro.mywetherapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = BlueDark,
    primaryVariant = BlueVariantDark,
    secondary = OrangeAccentDark
)

private val LightColorPalette = lightColors(
    primary = BlueLight,
    primaryVariant = BlueVariantLight,
    secondary = OrangeAccentLight
)

@Composable
fun MyWetherAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}