package com.example.toki.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toki.R
import com.example.toki.ui.theme.TokiTheme

@Composable
fun GenderCategory(modifier: Modifier = Modifier) {
        Row(modifier = modifier
            .fillMaxWidth()){
            Column(
                modifier = modifier.weight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.female_card_label ),
                    contentDescription = "Female")
                Image(painter = painterResource(id = R.drawable.female_card_content ),
                    contentDescription = "Female")
            }
            Column(
                modifier = modifier.weight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.male_card_label ),
                    contentDescription = "male")
                Image(painter = painterResource(id = R.drawable.male_card_content ),
                    contentDescription = "male")
            }
        }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGenderCategory() {
    TokiTheme {
        GenderCategory()
    }
}