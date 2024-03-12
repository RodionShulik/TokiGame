package com.example.toki.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Element(
    @DrawableRes val element : Int,
    val color : Color
)