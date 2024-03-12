package com.example.toki.ui.compositions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.toki.data.CharacterPart

@Composable
fun ChooseCharacterPart(
    modifier : Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    onPartClick : (CharacterPart) ->Unit,
    onTileClick : () ->Unit,
    tileColor : Color,
    partList : List<CharacterPart>
) {
    Column {
        LazyRow {
            items(partList) { item ->

                Box(
                    modifier = modifier
                        .padding(horizontal = 4.dp)
                        .size(
                            72.dp
                        )
                        .clip(
                            CircleShape
                        )
                        .clickable {
                            onPartClick(item)
                        }
                        .background(
                            Color(0xffc1bed4)
                        )
                ) {
                    Image(
                        modifier = imageModifier,
                        painter = painterResource(id = item.fillingPart.element),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                    Image(
                        modifier = imageModifier,
                        painter = painterResource(id = item.contourPart.element),
                        contentDescription = null
                    )
                }
            }
        }
        Row{
            ColorTile(
                modifier = modifier.size(36.dp),
                color = tileColor,
                navigateToDestination = {
                    onTileClick()
                },

                )
        }
    }
}