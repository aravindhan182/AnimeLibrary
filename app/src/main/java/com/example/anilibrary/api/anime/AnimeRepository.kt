package com.example.anilibrary.api.anime

import retrofit2.Response

class AnimeRepository {
    suspend fun getAnimeList(): Response<List<Anime>> {
        return AnimeService.api.getAnimeList()
    }
}