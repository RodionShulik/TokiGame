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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
    navigateToDestination: (String) -> Unit
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
    navigateToDestination: (String) -> Unit,
    contourColor: Color,
    fillingColor: Color
) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = modifier.weight(0.8f)) {
            GenderCard(
                modifier = modifier.weight(0.5f),
                label = R.drawable.female_card_label,
                content = R.drawable.female_card_content,
                contentDescription = "female",
                selectedCard = selectedCard,
                onSelectedCardClick = { gender -> onSelectedCardClick(gender) }
            )
        GenderCard(
            modifier = modifier
                .weight(0.5f),
            label = R.drawable.male_card_label,
            content = R.drawable.male_card_content,
            contentDescription = "male",
            selectedCard = selectedCard,
            onSelectedCardClick = { gender -> onSelectedCardClick(gender) }
        )
        }
        LazyVerticalGrid(
            modifier = Modifier.weight(0.2f).padding(start = 8.dp),
            columns = GridCells.Fixed(5),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                ColorTile(
                    modifier = Modifier.aspectRatio(1f),
                    color = fillingColor,
                    navigateToDestination = { navigateToDestination("body_filling") }
                )

            }
            item{
                ColorTile(
                    modifier = Modifier.aspectRatio(1f),
                    color = contourColor,
                    navigateToDestination = { navigateToDestination("body_contour") }
                )
            }
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
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().weight(0.15f),
            painter = painterResource(id = label),
            contentDescription = contentDescription
        )
        Card(
            modifier = Modifier
                .weight(0.85f)
                .fillMaxWidth()
                .border(
                    width = borderDp,
                    color = Color(0xFF07e0b1),
                    shape = MaterialTheme.shapes.medium
                )
                .clickable {
                    onSelectedCardClick(contentDescription)
                },
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF5b4b8a)
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = content),
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit
            )
        }
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