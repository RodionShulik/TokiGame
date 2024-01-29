package com.example.toki.ui.compositions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.toki.R

@Composable
fun ArrowBackImageButton(
    modifier: Modifier = Modifier,
    onArrowClick: () -> Unit
) {
    Image(
        modifier = modifier
            .width(64.dp)
            .height(40.dp)
            .padding(start = 8.dp)
            .clickable {
                onArrowClick()
            },
        painter = painterResource(id = R.drawable.arrow_back),
        contentDescription = "Arrow back",
    )
}