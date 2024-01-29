package com.example.toki.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.toki.ui.screens.CategoryContent
import com.example.toki.ui.screens.ChooseCategory
import com.example.toki.ui.screens.category.CategoryContent
import com.example.toki.ui.screens.choosecategory.ChooseCategoryContent

@Composable
fun NavGraphSidePane(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = ChooseCategory.route
    ) {
        composable(ChooseCategory.route) {
            ChooseCategoryContent(
                navigateToCategory = { categoryType -> navController.navigateToCategory(categoryType) }
            )
        }

        composable(
            route = CategoryContent.routeWithArgs,
            arguments = CategoryContent.arguments
        ) {navBackStackEntry->
            val categoryType =
                navBackStackEntry.arguments?.getString(CategoryContent.categoryTypeArg)
            CategoryContent(
                onArrowClick = {navController.navigateUp()  },
                categoryType = categoryType
            )
        }
    }
}

private fun NavHostController.navigateToCategory(categoryType: String) {
    this.navigate("${CategoryContent.route}/$categoryType")
}