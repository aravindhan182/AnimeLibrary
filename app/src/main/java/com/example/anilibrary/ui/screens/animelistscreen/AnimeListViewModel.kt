package com.example.anilibrary.ui.screens.animelistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.anilibrary.api.anime.AnimeRepository
import com.example.anilibrary.api.anime.AnimeService

class AnimeListViewModel(application: Application) : AndroidViewModel(application) {
    private val animeRepository = AnimeRepository(AnimeService)
    val animePagingData = animeRepository.getAnimePagingFlow().flow.cachedIn(viewModelScope)
}