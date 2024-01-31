package com.example.toki.ui.screens.colorpicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toki.ui.MainViewModel
import com.example.toki.ui.compositions.ArrowBackImageButton
import com.github.skydoves.colorpicker.compose.AlphaSlider
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.ColorEnvelope
import com.github.skydoves.colorpicker.compose.ColorPickerController
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

@Composable
fun ColorPickerScreenStateful(
    onArrowClick:()->Unit,
    mainViewModel: MainViewModel,
    characterElement: String?
){
    val controller = rememberColorPickerController()
    val currentColor = mainViewModel.colorFlow.collectAsState()
        ColorPickerScreenStateless(
            onArrowClick = {onArrowClick()},
            initialColor = currentColor.value,
            onColorChanged = {
                    colorEnvelope ->
                mainViewModel.changeElementColor(colorEnvelope.color,characterElement ?: "body_contour")
            },
            getColor = {mainViewModel.getColor(characterElement)},
            controller = controller
        )
}
// TODO: make stateles version
@Composable
fun ColorPickerScreenStateless(
    modifier:Modifier= Modifier,
    onArrowClick:()->Unit,
    initialColor : Color,
    onColorChanged : (ColorEnvelope) -> Unit,
    getColor : () -> Unit,
    controller :ColorPickerController
) {

    LaunchedEffect(key1 = Unit) {
        getColor()
    }
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.1f)
                .align(Alignment.Start)
        ){
            ArrowBackImageButton(
                onArrowClick = onArrowClick
            )
            Text(text = "Choose color", style = MaterialTheme.typography.titleLarge)
        }
        HsvColorPicker(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.5f) ,
            controller =controller,
            onColorChanged = {
                colorEnvelope ->
                onColorChanged(colorEnvelope)
            },
            initialColor = initialColor
        )
        AlphaSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .weight(0.2f),
            controller = controller,
        )
        BrightnessSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .weight(0.2f),
            controller = controller,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PrevColorPicker() {
    ColorPickerScreenStateful(onArrowClick = { /*TODO*/ }, mainViewModel = MainViewModel(), characterElement = "body_contour" )
}
