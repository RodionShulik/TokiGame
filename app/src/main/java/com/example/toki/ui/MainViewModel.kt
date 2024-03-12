package com.example.toki.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toki.R
import com.example.toki.data.Character
import com.example.toki.data.CharacterPart
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel :ViewModel() {
    private var _character = MutableStateFlow<Character>(Character())
    val character = _character.asStateFlow()

    fun setBody(gender:String){
        if(gender=="female"){
            _character.value = _character.value.copy(
                body = CharacterPart(
                    contourPart =_character.value.body.contourPart.copy(element = R.drawable.female_body_contour),
                    fillingPart = _character.value.body.fillingPart.copy(element = R.drawable.female_body_filling),
                ),
            )
        }else{
            _character.value = _character.value.copy(
                body = CharacterPart(
                    contourPart =_character.value.body.contourPart.copy(element = R.drawable.male_body_contour),
                    fillingPart = _character.value.body.fillingPart.copy(element = R.drawable.male_body_filling),
                ),
            )
        }
    }

    fun setBaseHair(hair:CharacterPart){
            _character.value = _character.value.copy(
                baseHair = CharacterPart(
                    fillingPart = character.value.baseHair.fillingPart.copy(
                        element = hair.fillingPart.element
                    ),
                    contourPart = hair.contourPart
                )
            )
    }
    fun setBangs(bangs:CharacterPart){
        _character.value = _character.value.copy(
            bangs = CharacterPart(
                fillingPart = character.value.bangs.fillingPart.copy(
                    element = bangs.fillingPart.element
                ),
                contourPart = bangs.contourPart
            )
        )
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
                            contourPart = _character.value.body.contourPart.copy(color = color),
                        )
                    )
                }
                "body_filling"->{
                    _character.value = _character.value.copy(
                        body = _character.value.body.copy(
                            fillingPart = _character.value.body.fillingPart.copy(color = color),
                        )
                    )
                }
                "base_hair"->{
                    _character.value = _character.value.copy(
                        baseHair =  _character.value.baseHair.copy(
                            fillingPart = _character.value.baseHair.fillingPart.copy(color = color)
                        )
                    )
                }
                "bangs"->{
                    _character.value = _character.value.copy(
                        bangs =  _character.value.bangs.copy(
                            fillingPart = _character.value.bangs.fillingPart.copy(color = color)
                        )
                    )
                }
            }
        }

    }
}