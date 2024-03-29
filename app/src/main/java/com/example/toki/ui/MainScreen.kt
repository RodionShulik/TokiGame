package com.example.toki.ui

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toki.R
import com.example.toki.ui.theme.TokiTheme
import my.nanihadesuka.compose.LazyColumnScrollbar

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val color1 = remember{
        Animatable(viewModel.character.value.body.fillingPart.color)
    }
    LaunchedEffect(key1 = Unit) {
        color1.animateTo(Color.Green , animationSpec = tween(500))
    }
    val character = viewModel.character.collectAsState().value
    Row(modifier = Modifier.fillMaxSize()) {

        Box(modifier = modifier.width(108.dp)) {
            LazyColumnScrollbar(
                listState,
                alwaysShowScrollBar = true,
                rightSide = true
            ) {
                LazyColumn(state = listState) {
                    items(15) { it ->
                        Image(
                            modifier = Modifier
                                .size(96.dp),
                            painter = painterResource(id = R.drawable.slot_item),
                            contentDescription = "slot №$it"
                        )

                    }
                }
            }
        }
        Column(modifier = modifier
            .fillMaxHeight()
            .weight(1.5f)) {
            Row{
                Image(
                    modifier = Modifier
                        .width(144.dp)
                        .padding(4.dp),
                    painter = painterResource(id = R.drawable.studio),
                    contentDescription = "Studio"
                )
                Text(
                    modifier = modifier.weight(1f),
                    text = "TOKI",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center
                )
                Image(
                    modifier = modifier
                        .size(72.dp)
                        .padding(4.dp),
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Settings"
                )
            }
            Box {
                Image(
                    modifier = modifier.fillMaxSize(),
                    painter = painterResource(id = character.body.fillingPart.element ?: R.drawable.empty_drawable),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(character.body.fillingPart.color)
                )
                Image(
                    modifier = modifier.fillMaxSize(),
                    painter = painterResource(id = character.body.contourPart.element ?: R.drawable.empty_drawable),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(character.body.contourPart.color ?: Color.Black)
                )
                Image(
                    modifier = modifier.fillMaxSize().alpha(0.2f),
                    painter = painterResource(id = character.bodyShadow.element ?: R.drawable.empty_drawable),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
                Image(
                    modifier = modifier.fillMaxSize(),
                    painter =  painterResource(id = character.baseHair.fillingPart.element),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(character.baseHair.fillingPart.color)
                )
                Image(
                    modifier = modifier.fillMaxSize(),
                    painter =  painterResource(id = character.baseHair.contourPart.element),
                    contentDescription = null
                )
                Image(
                    modifier = modifier.fillMaxSize(),
                    painter =  painterResource(id = character.bangs.fillingPart.element),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(character.bangs.fillingPart.color)
                )
                Image(
                    modifier = modifier.fillMaxSize(),
                    painter =  painterResource(id = character.bangs.contourPart.element),
                    contentDescription = null
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxHeight()
                .weight(1f)
                .background(
                    Color(0xffdee0ef)

                ),
        ) {
            //Border on the start side
            Spacer(
                modifier = modifier
                    .fillMaxHeight()
                    .width(5.dp)
                    .background(Color(0XFF6c5c88))
            )
            Column {
                Text(
                    text = "TOKI",
                    style = MaterialTheme.typography.displaySmall,
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                SidePaneContent(viewModel)
            }
        }
    }
}


@Composable
fun SidePaneContent(mainViewModel: MainViewModel) {
    NavGraphSidePane(mainViewModel = mainViewModel)
}



@Preview(
    showBackground = true,
    device = "spec:width=760dp,height=393dp,dpi=440,orientation=landscape"
)
@Composable
private fun PreviewMainScreen() {
    val listState = rememberLazyListState()
    TokiTheme {
        MainScreen(listState = listState)
    }
}