package com.example.anilibrary.api.anime

import retrofit2.Response
import retrofit2.http.GET

interface AnimeAPI {
    @GET("v4/top/anime")
    suspend fun getAnimeList(): Response<List<Anime>>
}