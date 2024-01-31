package com.example.toki.ui.screens.category

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toki.R
import com.example.toki.ui.MainViewModel
import com.example.toki.ui.compositions.ColorTile
import com.example.toki.ui.theme.TokiTheme


@Composable
fun GenderScreenStateful(
    mainViewModel: MainViewModel,
    navigateToDestination: (String) ->Unit
) {
    var selectedCard by rememberSaveable {
        mutableStateOf<String>("female")
    }
    val contourColor = mainViewModel.character.collectAsState().value.body.bodyContour.color
    val fillingColor = mainViewModel.character.collectAsState().value.body.bodyFilling.color
    GenderScreenStateless(
        selectedCard = selectedCard,
        onSelectedCardClick = { gender ->
            selectedCard = gender
            mainViewModel.setBody(gender)
                              },
        navigateToDestination = navigateToDestination,
        contourColor = contourColor,
        fillingColor = fillingColor
    )
}

@Composable
fun GenderScreenStateless(
    modifier: Modifier = Modifier,
    selectedCard: String,
    onSelectedCardClick: (String) -> Unit,
    navigateToDestination: (String) ->Unit,
    contourColor:Color,
    fillingColor:Color
) {
        Column(modifier = modifier.fillMaxSize()) {
            Row(modifier = modifier) {
                GenderCard(
                    modifier = modifier.weight(0.5f),
                    label = R.drawable.female_card_label,
                    content = R.drawable.female_card_content,
                    contentDescription = "female",
                    selectedCard = selectedCard,
                    onSelectedCardClick = { gender -> onSelectedCardClick(gender) }
                )
                GenderCard(
                    modifier = modifier.weight(0.5f),
                    label = R.drawable.male_card_label,
                    content = R.drawable.male_card_content,
                    contentDescription = "male",
                    selectedCard = selectedCard,
                    onSelectedCardClick = { gender -> onSelectedCardClick(gender) }
                )
            }
            Row(
                modifier = modifier.padding(start = 16.dp , top = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                ColorTile(
                    color = fillingColor,
                    navigateToDestination = {navigateToDestination("body_filling")}
                )
                ColorTile(
                    color = contourColor,
                    navigateToDestination = {navigateToDestination("body_contour")}
                )
            }

        }
}

@Composable
fun GenderCard(
    modifier: Modifier = Modifier,
    @DrawableRes label: Int,
    @DrawableRes content: Int,
    contentDescription: String,
    selectedCard: String = "",
    onSelectedCardClick: (String) -> Unit
) {
    val borderDp by animateDpAsState(
        if (selectedCard == contentDescription) {
            6.dp
        } else {
            (-1).dp
        },
        label = "Width border",
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing
        )
    )


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = label),
            contentDescription = contentDescription
        )
        Image(
            modifier = Modifier
                .border(
                    width = borderDp,
                    color = Color(0xFF07e0b1),
                    shape = MaterialTheme.shapes.small
                )
                .clickable {
                    onSelectedCardClick(contentDescription)
                },
            painter = painterResource(id = content),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF3F51B5)
@Composable
private fun PreviewGenderCategory() {
    TokiTheme {
        GenderScreenStateful(
            mainViewModel = MainViewModel(),
            navigateToDestination = {}
        )
    }
}