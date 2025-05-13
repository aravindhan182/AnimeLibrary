package com.example.anilibrary.api.animedetails

import com.example.anilibrary.util.RetrofitBuilder

object AnimeDetailService {
    val api: AnimeDetailsAPI by lazy {
        RetrofitBuilder.buildService(AnimeDetailsAPI::class.java)
    }
}