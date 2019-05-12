package com.venkateshpamarthi.kotlin_retrofit.feature_weather.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.WeatherRepository
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.model.ResponseModel
import kotlinx.coroutines.*

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val popularMoviesLiveData = MutableLiveData<ResponseModel>()

    fun fetchWeather(countryCode: String):MutableLiveData<ResponseModel>{
        CoroutineScope(Dispatchers.IO).launch{
            val result = weatherRepository.getWeatherDetails(countryCode)
            withContext(Dispatchers.Main){
                popularMoviesLiveData.postValue(result)
            }
        }
        return popularMoviesLiveData
    }
}
