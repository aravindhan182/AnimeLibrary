package com.example.anilibrary.ui.screens.animedetailscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.anilibrary.api.animedetails.AnimeDetailsRepository

class AnimeDetailsViewModel(application: Application) : AndroidViewModel(application) {
    val animeDetailsRepository = AnimeDetailsRepository()
}