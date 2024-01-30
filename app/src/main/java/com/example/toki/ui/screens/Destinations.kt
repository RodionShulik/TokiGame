package com.example.toki.ui.screens

import androidx.navigation.NavType
import androidx.navigation.navArgument


interface SidePaneDestination{
    val route:String
}

object ChooseCategory : SidePaneDestination{
    override val route: String = "side_pane/choose_categories"
}

object CategoryContent : SidePaneDestination{
    override val route: String = "side_pane/category_content"
    const val categoryTypeArg = "category_type"
    val routeWithArgs = "$route/{$categoryTypeArg}"

    val arguments = listOf(
        navArgument(categoryTypeArg) { type = NavType.StringType }
    )
}

object ColorPicker : SidePaneDestination{
    override val route = "side_pane/pick_color"
    const val characterElementArg = "character_element"
    val routeWithArgs = "$route/{$characterElementArg}"

    val arguments = listOf(
        navArgument(characterElementArg){ type = NavType.StringType}
    )
}
