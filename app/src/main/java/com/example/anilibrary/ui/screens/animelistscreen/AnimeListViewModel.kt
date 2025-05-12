package com.example.anilibrary.ui.screens.animelistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.anilibrary.api.anime.AnimeRepository

class AnimeListViewModel(application: Application) : AndroidViewModel(application) {
    val animeRepository = AnimeRepository()
}