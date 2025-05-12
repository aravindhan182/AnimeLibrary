package com.example.anilibrary.api.anime

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AnimeService {
    private const val BASE_URL = "https://api.jikan.moe"

    val api: AnimeAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeAPI::class.java)
    }
}