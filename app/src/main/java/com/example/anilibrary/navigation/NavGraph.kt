package com.example.anilibrary.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.anilibrary.ui.screens.animedetailscreen.AnimeDetailsScreen
import com.example.anilibrary.ui.screens.animelistscreen.AnimeListViewModel
import com.example.anilibrary.ui.screens.animelistscreen.AnimeScreen

@Composable
fun NavGraph(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    val animeListViewModel: AnimeListViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screen.AnimeScreen.route) {
        composable(route = Screen.AnimeScreen.route) {
            AnimeScreen(
                navController = navController,
                paddingValues = paddingValues,
                viewModel = animeListViewModel
            )
        }
        composable(
            route = "anime_detail_screen/{animeId}",
            arguments = listOf(navArgument("animeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val animeId = backStackEntry.arguments?.getInt("animeId") ?: -1
            AnimeDetailsScreen(navController = navController, paddingValues = paddingValues, animeId = animeId)
        }
    }
}