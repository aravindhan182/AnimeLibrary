package com.example.anilibrary.api.animedetails

import retrofit2.Response

class AnimeDetailsRepository {
    suspend fun getAnimeDetails(animeId: Int): Response<AnimeResponse> {
        return AnimeDetailService.api.getAnimeDetails(animeId)
    }
}