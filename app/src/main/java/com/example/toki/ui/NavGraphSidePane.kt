package com.example.toki.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.toki.ui.screens.choosecategory.ChooseCategoryContent

enum class SidePaneScreen(val route: String) {
    ChooseCategory(route = "side-pane/choose-categories"),
    Category(route = "side-pane/category")
}

@Composable
fun NavGraphSidePane(
    modifier: Modifier=Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        modifier = modifier.fillMaxSize() ,
        navController = navController,
        startDestination = SidePaneScreen.ChooseCategory.route
    ) {
        composable(SidePaneScreen.ChooseCategory.route) {
            ChooseCategoryContent()
        }
    }
}