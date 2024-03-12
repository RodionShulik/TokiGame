package com.example.toki.data

import androidx.compose.ui.graphics.Color
import com.example.toki.R
import com.example.toki.ui.screens.category.DEFAULT_CONTOUR_COLOR
import com.example.toki.ui.screens.category.DEFAULT_HAIR_COLOR

data class Character(
    val face: CharacterPart? = null,
    val baseHair: CharacterPart = CharacterPart(
        fillingPart = Element(element = R.drawable.base_hair_filling_1, color = DEFAULT_HAIR_COLOR),
        contourPart = Element(element = R.drawable.base_hair_contour_1, color = DEFAULT_CONTOUR_COLOR)
    ),
    val backHair: CharacterPart? = null,
    val bangs: CharacterPart = CharacterPart(
        fillingPart = Element(element = R.drawable.bangs_filling_1, color = DEFAULT_HAIR_COLOR),
        contourPart = Element(element = R.drawable.bangs_contour_1, color = DEFAULT_CONTOUR_COLOR)
    ),
    val tShirt: CharacterPart? = null,
    val pants: CharacterPart? = null,
    val body: CharacterPart = CharacterPart(
        fillingPart = Element(element = R.drawable.female_body_filling, color = Color.White),
        contourPart = Element(element = R.drawable.female_body_contour, color = Color.Black)
    ),
    val bodyShadow: Element = Element(
        element = R.drawable.female_body_shadow,
        color = Color.Gray
    ),
    val hat: CharacterPart? = null
)