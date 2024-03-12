package com.example.toki.ui.screens.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.toki.R
import com.example.toki.data.CharacterPart
import com.example.toki.data.Element
import com.example.toki.ui.MainViewModel
import com.example.toki.ui.compositions.ChooseCharacterPart

val DEFAULT_HAIR_COLOR = Color(0xFFe2c7ce)
val DEFAULT_CONTOUR_COLOR = Color.Black

val baseHairList = listOf(
    CharacterPart(
        fillingPart = Element(
            element = R.drawable.base_hair_filling_1,
            color = DEFAULT_HAIR_COLOR
        ),
        contourPart = Element(
            element = R.drawable.base_hair_contour_1,
            color = DEFAULT_CONTOUR_COLOR
        )
    ),
    CharacterPart(
        fillingPart = Element(
            element = R.drawable.base_hair_filling_2,
            color = DEFAULT_HAIR_COLOR
        ),
        contourPart = Element(
            element = R.drawable.base_hair_contour_2,
            color = DEFAULT_CONTOUR_COLOR
        )
    ),
    CharacterPart(
        fillingPart = Element(
            element = R.drawable.base_hair_filling_3,
            color = DEFAULT_HAIR_COLOR
        ),
        contourPart = Element(
            element = R.drawable.base_hair_contour_3,
            color = DEFAULT_CONTOUR_COLOR
        )
    ),
    CharacterPart(
        fillingPart = Element(
            element = R.drawable.base_hair_filling_4,
            color = DEFAULT_HAIR_COLOR
        ),
        contourPart = Element(
            element = R.drawable.base_hair_contour_4,
            color = DEFAULT_CONTOUR_COLOR
        )
    )
)

val bangList = listOf(
        CharacterPart(
        fillingPart = Element(
            element = R.drawable.bangs_filling_1,
            color = DEFAULT_HAIR_COLOR
        ),
        contourPart = Element(
            element = R.drawable.bangs_contour_1,
            color = DEFAULT_CONTOUR_COLOR
        )
    ),
    CharacterPart(
        fillingPart = Element(
            element = R.drawable.bangs_filling_2,
            color = DEFAULT_HAIR_COLOR
        ),
        contourPart = Element(
            element = R.drawable.bangs_contour_2,
            color = DEFAULT_CONTOUR_COLOR
        )
    ),
    CharacterPart(
        fillingPart = Element(
            element = R.drawable.bangs_filling_3,
            color = DEFAULT_HAIR_COLOR
        ),
        contourPart = Element(
            element = R.drawable.bangs_contour_3,
            color = DEFAULT_CONTOUR_COLOR
        )
    ),
    CharacterPart(
        fillingPart = Element(
            element = R.drawable.bangs_filling_4,
            color = DEFAULT_HAIR_COLOR
        ),
        contourPart = Element(
            element = R.drawable.bangs_contour_4,
            color = DEFAULT_CONTOUR_COLOR
        )
    )
)
@Composable
fun FaceScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    navigateToDestination : (String) ->Unit
) {
    val baseHairFillingColor = mainViewModel.character.collectAsState().value.baseHair.fillingPart.color
    val bangsFillingColor = mainViewModel.character.collectAsState().value.bangs.fillingPart.color
    Column {
        ChooseCharacterPart(
            imageModifier = modifier
                .requiredSize(124.dp)
                .offset(y = 24.dp),
            onPartClick = { item-> mainViewModel.setBaseHair(item)},
            onTileClick = { navigateToDestination("base_hair")},
            tileColor = baseHairFillingColor ,
            partList = baseHairList
        )
        ChooseCharacterPart(
            imageModifier = modifier
                .requiredSize(124.dp)
                .offset(y = 24.dp),
            onPartClick = { item-> mainViewModel.setBangs(item) },
            onTileClick = { navigateToDestination("bangs") },
            tileColor = bangsFillingColor  ,
            partList = bangList
        )
    }

}