package com.example.anilibrary.api.animedetails

import com.example.anilibrary.api.anime.AnimeAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AnimeDetailService {
    private const val BASE_URL = "https://api.jikan.moe/"

    val api: AnimeDetailsAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeDetailsAPI::class.java)
    }
}