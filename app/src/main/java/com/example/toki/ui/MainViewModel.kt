package com.example.toki.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.toki.R
import com.example.toki.data.Body
import com.example.toki.data.Character
import com.example.toki.data.CharacterElement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel :ViewModel() {
    private var _character = MutableStateFlow<Character>(Character())
    val character = _character.asStateFlow()


    fun setBody(gender:String){
        if(gender=="female"){
            _character.value = _character.value.copy(
                body = Body(
                    bodyContour = CharacterElement(R.drawable.female_body_contour, Color(0XFF00D138)),
                    bodyFilling = CharacterElement(R.drawable.female_body_filling , Color.Red),
                    press = CharacterElement(R.drawable.female_press , Color.Cyan)
                )
            )
        }else{
            _character.value = _character.value.copy(
                body = Body(
                    bodyContour = CharacterElement(R.drawable.male_body_contour, Color(0XFF00D138)),
                    bodyFilling = CharacterElement(R.drawable.male_body_filling , Color.Red),
                    press = CharacterElement(R.drawable.male_press , Color.Cyan)
                )
            )
        }
    }

}