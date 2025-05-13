package com.example.anilibrary.api.animedetails

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeDetailsAPI {
    @GET("v4/anime/{anime_id}")
    suspend fun getAnimeDetails(@Path("anime_id") animeId: Int): Response<AnimeResponse>
}