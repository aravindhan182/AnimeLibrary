package com.example.anilibrary.ui.screens.animedetailscreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.anilibrary.api.animedetails.AnimeDetailsRepository
import com.example.anilibrary.api.animedetails.AnimeResponse
import com.example.anilibrary.util.Result
import com.example.anilibrary.util.isInternetAvailable
import kotlinx.coroutines.launch
import retrofit2.Response

class AnimeDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val animeDetailsRepository = AnimeDetailsRepository()

    val animeDetails: MutableLiveData<Result<AnimeResponse>> = MutableLiveData()

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    private val _noInternet: MutableLiveData<Boolean> = MutableLiveData()
    val noInternet: LiveData<Boolean> = _noInternet

    fun getAnimalDetails(animeId: Int) {
        if (isInternetAvailable(getApplication())) {
            _loading.value = true
            viewModelScope.launch {
                animeDetails.value =
                    handleListDataResponse(animeDetailsRepository.getAnimeDetails(animeId))
            }
        } else {
            _noInternet.value = true
        }
    }

    private fun handleListDataResponse(response: Response<AnimeResponse>): Result<AnimeResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                _loading.value = false
                Log.d("AnimeDetailsScreen", "Data: $resultResponse")
                return Result.Success(resultResponse)
            }
        }
        return Result.Error(null, response.message())
    }
}