package com.example.anilibrary.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.anilibrary.api.anime.Anime
import com.example.anilibrary.api.anime.AnimeService

class AnimePagingSource(
    private val apiService: AnimeService
) : PagingSource<Int, Anime>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        val page = params.key ?: 1
        return try {
            val response = apiService.api.getAnimeList(page)
            LoadResult.Page(
                data = response.body()?.data ?: emptyList(),
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.body()?.pagination!!.hasNextPage) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}
