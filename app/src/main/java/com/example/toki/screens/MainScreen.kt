package com.example.toki.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.toki.R
import my.nanihadesuka.compose.LazyColumnScrollbar

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    Row(modifier = Modifier.fillMaxWidth()) {
            LazyColumnScrollbar(
                listState,
                alwaysShowScrollBar = true,
                rightSide = false
            ) {
                LazyColumn(state = listState) {
                    items(15) { it ->
                        Image(
                            modifier = Modifier
                                .padding(start = 14.dp)
                                .size(96.dp),
                            painter = painterResource(id = R.drawable.slot_item),
                            contentDescription = "slot №$it"
                        )

                    }
                }
            }

    }
}