package com.example.anilibrary.api.anime

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeAPI {
    @GET("v4/top/anime")
    suspend fun getAnimeList(
        @Query("page") page: Int
    ): Response<AnimeResponse>
}