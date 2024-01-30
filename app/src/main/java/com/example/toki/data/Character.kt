package com.example.toki.data

import androidx.compose.ui.graphics.Color
import com.example.toki.R

data class Character(
    val face : CharacterElement? = null,
    val tShirt : CharacterElement?= null,
    val pants : CharacterElement?= null,
    val body : Body = Body(
        bodyContour = CharacterElement(element = R.drawable.female_body_contour, color = Color.Black),
        bodyFilling = CharacterElement(element = R.drawable.female_body_filling, color = Color.White),
        press = CharacterElement(element = R.drawable.female_press , color =  Color.Gray)
    ),
    val hat : CharacterElement?= null
)