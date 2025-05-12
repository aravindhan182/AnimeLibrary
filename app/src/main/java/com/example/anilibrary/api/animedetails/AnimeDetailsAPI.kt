package com.example.anilibrary.api.animedetails

import retrofit2.Response
import retrofit2.http.GET

interface AnimeDetailsAPI {
    @GET("v4/anime/{anime_id}")
    suspend fun getAnimeDetails(): Response<AnimeDetails>
}