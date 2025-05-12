package com.example.anilibrary.ui.screens.animelistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.anilibrary.api.anime.Anime
import com.example.anilibrary.api.anime.AnimeRepository
import com.example.anilibrary.util.Result
import kotlinx.coroutines.launch
import retrofit2.Response

class AnimeListViewModel(application: Application) : AndroidViewModel(application) {
    private val animeRepository = AnimeRepository()

    private val _anime: MutableLiveData<Result<List<Anime>>> = MutableLiveData()
    val anime: LiveData<Result<List<Anime>>> = _anime

    init {
        viewModelScope.launch {
            _anime.value = handleListDataResponse(animeRepository.getAnimeList())
        }
    }

    private fun handleListDataResponse(response: Response<List<Anime>>): Result<List<Anime>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Result.Success(resultResponse)
            }
        }
        return Result.Error(null, response.message())
    }
}