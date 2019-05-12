package com.venkateshpamarthi.kotlin_retrofit.feature_weather.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.WeatherRepository

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory(private val weatherRepository: WeatherRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return WeatherViewModel(weatherRepository) as T
    }
}