/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.compose.jetsurvey.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.surveyapp.ui.theme.Shapes
import com.example.surveyapp.ui.theme.md_theme_dark_background
import com.example.surveyapp.ui.theme.md_theme_dark_error
import com.example.surveyapp.ui.theme.md_theme_dark_errorContainer
import com.example.surveyapp.ui.theme.md_theme_dark_inverseOnSurface
import com.example.surveyapp.ui.theme.md_theme_dark_inversePrimary
import com.example.surveyapp.ui.theme.md_theme_dark_inverseSurface
import com.example.surveyapp.ui.theme.md_theme_dark_onBackground
import com.example.surveyapp.ui.theme.md_theme_dark_onError
import com.example.surveyapp.ui.theme.md_theme_dark_onErrorContainer
import com.example.surveyapp.ui.theme.md_theme_dark_onPrimary
import com.example.surveyapp.ui.theme.md_theme_dark_onPrimaryContainer
import com.example.surveyapp.ui.theme.md_theme_dark_onSecondary
import com.example.surveyapp.ui.theme.md_theme_dark_onSecondaryContainer
import com.example.surveyapp.ui.theme.md_theme_dark_onSurface
import com.example.surveyapp.ui.theme.md_theme_dark_onSurfaceVariant
import com.example.surveyapp.ui.theme.md_theme_dark_onTertiary
import com.example.surveyapp.ui.theme.md_theme_dark_onTertiaryContainer
import com.example.surveyapp.ui.theme.md_theme_dark_outline
import com.example.surveyapp.ui.theme.md_theme_dark_primary
import com.example.surveyapp.ui.theme.md_theme_dark_primaryContainer
import com.example.surveyapp.ui.theme.md_theme_dark_secondary
import com.example.surveyapp.ui.theme.md_theme_dark_secondaryContainer
import com.example.surveyapp.ui.theme.md_theme_dark_surface
import com.example.surveyapp.ui.theme.md_theme_dark_surfaceTint
import com.example.surveyapp.ui.theme.md_theme_dark_surfaceVariant
import com.example.surveyapp.ui.theme.md_theme_dark_tertiary
import com.example.surveyapp.ui.theme.md_theme_dark_tertiaryContainer
import com.example.surveyapp.ui.theme.md_theme_light_background
import com.example.surveyapp.ui.theme.md_theme_light_error
import com.example.surveyapp.ui.theme.md_theme_light_errorContainer
import com.example.surveyapp.ui.theme.md_theme_light_inverseOnSurface
import com.example.surveyapp.ui.theme.md_theme_light_inversePrimary
import com.example.surveyapp.ui.theme.md_theme_light_inverseSurface
import com.example.surveyapp.ui.theme.md_theme_light_onBackground
import com.example.surveyapp.ui.theme.md_theme_light_onError
import com.example.surveyapp.ui.theme.md_theme_light_onErrorContainer
import com.example.surveyapp.ui.theme.md_theme_light_onPrimary
import com.example.surveyapp.ui.theme.md_theme_light_onPrimaryContainer
import com.example.surveyapp.ui.theme.md_theme_light_onSecondary
import com.example.surveyapp.ui.theme.md_theme_light_onSecondaryContainer
import com.example.surveyapp.ui.theme.md_theme_light_onSurface
import com.example.surveyapp.ui.theme.md_theme_light_onSurfaceVariant
import com.example.surveyapp.ui.theme.md_theme_light_onTertiary
import com.example.surveyapp.ui.theme.md_theme_light_onTertiaryContainer
import com.example.surveyapp.ui.theme.md_theme_light_outline
import com.example.surveyapp.ui.theme.md_theme_light_primary
import com.example.surveyapp.ui.theme.md_theme_light_primaryContainer
import com.example.surveyapp.ui.theme.md_theme_light_secondary
import com.example.surveyapp.ui.theme.md_theme_light_secondaryContainer
import com.example.surveyapp.ui.theme.md_theme_light_surface
import com.example.surveyapp.ui.theme.md_theme_light_surfaceTint
import com.example.surveyapp.ui.theme.md_theme_light_surfaceVariant
import com.example.surveyapp.ui.theme.md_theme_light_tertiary
import com.example.surveyapp.ui.theme.md_theme_light_tertiaryContainer
import com.example.surveyapp.ui.theme.typo
import android.os.Build
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.ui.platform.LocalContext
import com.example.surveyapp.ui.theme.Pink40
import com.example.surveyapp.ui.theme.Pink80
import com.example.surveyapp.ui.theme.Purple40
import com.example.surveyapp.ui.theme.Purple80
import com.example.surveyapp.ui.theme.PurpleGrey40
import com.example.surveyapp.ui.theme.PurpleGrey80
import com.example.surveyapp.ui.theme.Typography


private val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    errorContainer = md_theme_light_errorContainer,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseSurface = md_theme_light_inverseSurface,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
)

private val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    errorContainer = md_theme_dark_errorContainer,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseSurface = md_theme_dark_inverseSurface,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
)

@Composable
fun JetsurveyTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    MaterialTheme(
        colorScheme = colors,
        shapes = Shapes,
        typography = typo,
        content = content,
    )
}



private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun SurveyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
