package com.example.anilibrary.api.animedetails

import retrofit2.Response

class AnimeDetailsRepository {
    suspend fun getAnimeDetails(): Response<AnimeDetails> {
        return AnimeDetailService.api.getAnimeDetails()
    }
}