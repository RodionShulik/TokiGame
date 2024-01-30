package com.example.toki.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class CharacterElement(
    @DrawableRes val element : Int,
    val color : Color
)