package com.example.toki.data

import androidx.annotation.DrawableRes
import com.example.toki.R


data class DataCategory(
    val name: String ,
    @DrawableRes val drawable :Int
)
val categoryList:List<DataCategory> = listOf(
    DataCategory("face" , R.drawable.face_category),
    DataCategory("t-shirt", R.drawable.t_shirt_category),
    DataCategory("pants", R.drawable.pants_category),
    DataCategory("gender", R.drawable.gender_category),
    DataCategory("hat", R.drawable.hat_category)
)
