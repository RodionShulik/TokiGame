package com.example.toki.ui

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toki.R
import com.example.toki.data.Body
import com.example.toki.data.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel :ViewModel() {
    private var _character = MutableStateFlow<Character>(Character())
    val character = _character.asStateFlow()

    private var _colorFLow = MutableStateFlow(Color.Transparent)
    val colorFlow = _colorFLow.asStateFlow()
    fun setBody(gender:String){
        if(gender=="female"){
            _character.value = _character.value.copy(
                body = Body(
                    bodyContour =_character.value.body.bodyContour.copy(element = R.drawable.female_body_contour),
                    bodyFilling = _character.value.body.bodyFilling.copy(element = R.drawable.female_body_filling),
                    press = _character.value.body.press.copy(element = R.drawable.female_press),
                )
            )
        }else{
            _character.value = _character.value.copy(
                body = Body(
                    bodyContour =_character.value.body.bodyContour.copy(element = R.drawable.male_body_contour),
                    bodyFilling = _character.value.body.bodyFilling.copy(element = R.drawable.male_body_filling),
                    press = _character.value.body.press.copy(element = R.drawable.male_press),
                )
            )
        }
    }

    fun changeElementColor(
        color:Color,
        element : String
    ){
        viewModelScope.launch {
            when(element){
                "body_contour"->{
                    _character.value = _character.value.copy(
                        body = _character.value.body.copy(
                            bodyContour = _character.value.body.bodyContour.copy(color = color),
                        )
                    )
                }
                "body_filling"->{
                    _character.value = _character.value.copy(
                        body = _character.value.body.copy(
                            bodyFilling = _character.value.body.bodyFilling.copy(color = color),
                        )
                    )
                }
            }
        }

    }
    fun getColor (element: String?){
        when(element){

            "body_contour" -> _colorFLow.value = _character.value.body.bodyContour.color
            "body_filling" -> _colorFLow.value = _character.value.body.bodyFilling.color

            else->_colorFLow.value = _character.value.body.bodyContour.color
        }
        Log.d("color_test", "FLOW:${_colorFLow.value}")
    }
}