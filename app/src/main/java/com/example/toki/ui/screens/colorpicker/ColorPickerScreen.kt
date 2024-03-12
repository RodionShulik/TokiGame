package com.example.toki.ui.screens.colorpicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    val controller = rememberColorPickerController();
    ColorPickerScreenStateless(
            onArrowClick = {onArrowClick()},
            onColorChanged = {
                    colorEnvelope ->
                mainViewModel.changeElementColor(colorEnvelope.color,characterElement ?: "body_contour")
            },
            controller = controller
    )
}
@Composable
fun ColorPickerScreenStateless(
    modifier:Modifier= Modifier,
    onArrowClick:()->Unit,
    onColorChanged : (ColorEnvelope) -> Unit,
    controller :ColorPickerController
) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
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
                .weight(0.4f) ,
            controller =controller,
            onColorChanged = {
                colorEnvelope ->
                onColorChanged(colorEnvelope)
            },
        )
        AlphaSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp, horizontal = 8.dp)
                .height(32.dp),
            controller = controller,
        )
        BrightnessSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp, horizontal = 8.dp)
                .height(32.dp),
            controller = controller,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PrevColorPicker() {
    ColorPickerScreenStateful(onArrowClick = { /*TODO*/ }, mainViewModel = MainViewModel(), characterElement = "body_contour" )
}
