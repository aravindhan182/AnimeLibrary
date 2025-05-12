package com.example.anilibrary.api.anime

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.anilibrary.pagination.AnimePagingSource

class AnimeRepository(private val apiService: AnimeService) {
    fun getAnimePagingFlow(): Pager<Int, Anime> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = { AnimePagingSource(apiService) }
        )
    }
}