package com.example.toki.ui.screens.choosecategory

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toki.R
import com.example.toki.ui.theme.TokiTheme

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
@Composable
fun ChooseCategoryContent(
    modifier: Modifier = Modifier,
    navigateToCategory :(String)->Unit={}){
    Column(modifier = modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(72.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(categoryList){ category->
                Image(
                    modifier = modifier
                        .size(72.dp)
                        .clickable{
                            navigateToCategory(category.name)
                        },
                    painter = painterResource(id = category.drawable),
                    contentDescription = category.name)
            }
        }
    }
}

@Preview(showBackground = true,
    device = "spec:id=reference_foldable,shape=Normal,width=673,height=841,unit=dp,dpi=420"
)
@Composable
private fun PreviewChooseCategoryContent() {
    TokiTheme {
        ChooseCategoryContent()
    }
}