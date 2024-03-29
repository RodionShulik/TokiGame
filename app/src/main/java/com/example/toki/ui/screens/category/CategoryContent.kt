package com.example.toki.ui.screens.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.toki.ui.MainViewModel
import com.example.toki.ui.compositions.ArrowBackImageButton
import com.example.toki.ui.theme.TokiTheme

@Composable
fun CategoryContent(
    modifier:Modifier = Modifier,
    onArrowClick:()->Unit = {},
    categoryType:String? = "TEST",
    mainViewModel: MainViewModel,
    navigateToDestination : (String) ->Unit
) {
    Column(modifier = modifier
        .fillMaxSize()){
        ArrowBackImageButton(
            modifier = modifier.align(Alignment.Start),
            onArrowClick = onArrowClick
        )
        when(categoryType){
            "gender" -> GenderScreenStateful(
                mainViewModel = mainViewModel,
                navigateToDestination = navigateToDestination
            )
            "face" -> FaceScreen(
                mainViewModel = mainViewModel,
                navigateToDestination = navigateToDestination
            )
            else -> Text(text = categoryType!! , style = MaterialTheme.typography.displayLarge)

        }
    }
}

@Preview
@Composable
private fun PreviewCategoryContent() {
    TokiTheme {
        CategoryContent(
            mainViewModel = MainViewModel(),
            navigateToDestination = {}
        )
    }
}