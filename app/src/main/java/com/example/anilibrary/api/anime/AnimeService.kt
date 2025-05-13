package com.example.anilibrary.api.anime

import com.example.anilibrary.util.RetrofitBuilder

object AnimeService {
    val api: AnimeAPI by lazy {
        RetrofitBuilder.buildService(AnimeAPI::class.java)
    }
}