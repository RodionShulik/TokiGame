package com.example.toki.ui.screens.colorpicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.toki.ui.MainViewModel
import com.example.toki.ui.compositions.ArrowBackImageButton
import com.github.skydoves.colorpicker.compose.AlphaSlider
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.ColorEnvelope
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController


// TODO: make stateles version
@Composable
fun ColorPickerScreen(
    modifier:Modifier= Modifier,
    onArrowClick:()->Unit,
    mainViewModel: MainViewModel,
    characterElement: String?
) {
    val controller = rememberColorPickerController()
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .align(Alignment.Start)
                .weight(0.1f)
        ){
            ArrowBackImageButton(
                onArrowClick = onArrowClick
            )
            Text(text = "Choose color", style = MaterialTheme.typography.titleLarge)
        }
        HsvColorPicker(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .padding(10.dp),
            controller = controller,
            onColorChanged = { colorEnvelope: ColorEnvelope ->
                mainViewModel.changeElementColor(
                    color = colorEnvelope.color,
                    element = characterElement ?: "body_contour"
                )
            },
//todo make initialColor
        )
        AlphaSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .weight(0.2f)
            ,
            controller = controller,
        )
        BrightnessSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .weight(0.2f),
            controller = controller,
        )
//        AlphaTile(
//            modifier = Modifier
//                .weight(0.1f)
//                .clip(RoundedCornerShape(6.dp)),
//            controller = controller
//        )

    }
}