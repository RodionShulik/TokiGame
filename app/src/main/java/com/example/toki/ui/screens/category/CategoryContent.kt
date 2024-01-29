package com.example.toki.ui.screens.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.toki.ui.compositions.ArrowBackImageButton
import com.example.toki.ui.theme.TokiTheme

@Composable
fun CategoryContent(
    modifier:Modifier = Modifier,
    onArrowClick:()->Unit = {},
    categoryType:String? = "TEST"
) {
    Column(modifier = modifier
        .fillMaxSize()){
        ArrowBackImageButton(
            modifier = modifier.align(Alignment.Start),
            onArrowClick = onArrowClick
        )
        Text(text = (categoryType!!), style = MaterialTheme.typography.displayLarge)
    }
}

@Preview
@Composable
private fun PreviewCategoryContent() {
    TokiTheme {
        CategoryContent()
    }
}