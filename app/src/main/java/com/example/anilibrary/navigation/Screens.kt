package com.example.anilibrary.navigation

sealed class Screen(val route: String) {
    data object AnimeScreen : Screen("anime_screen")
    data object AnimeDetailScreen : Screen("anime_detail_screen/{animeId}") {
        fun createRoute(animeId: Int) = "anime_detail_screen/$animeId"
    }
}