package com.example.toki.ui.compositions

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorTile(
    modifier :Modifier = Modifier,
    color:Color,
    navigateToDestination: () ->Unit,
) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(color)
        .border(width = 2.dp, color = Color.Black)
        .clickable {
            navigateToDestination()
        }
    )
}