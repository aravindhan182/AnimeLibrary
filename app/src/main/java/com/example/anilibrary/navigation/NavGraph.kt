package com.example.anilibrary.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anilibrary.ui.screens.animedetailscreen.AnimeDetailsScreen
import com.example.anilibrary.ui.screens.animelistscreen.AnimeScreen

@Composable
fun NavGraph(paddingValues: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.AnimeScreen.route) {
        composable(route = Screen.AnimeScreen.route) {
            AnimeScreen(navController = navController, paddingValues)
        }
        composable(route = Screen.AnimeDetailScreen.route) {
            AnimeDetailsScreen(navController = navController, paddingValues)
        }
    }
}