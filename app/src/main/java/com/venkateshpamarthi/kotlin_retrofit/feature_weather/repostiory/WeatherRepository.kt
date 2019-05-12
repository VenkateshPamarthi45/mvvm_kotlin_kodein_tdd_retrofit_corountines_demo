package com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory

import android.support.annotation.WorkerThread
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.model.ResponseModel

interface WeatherRepository {
    @WorkerThread
    suspend fun getWeatherDetails(countryCode: String): ResponseModel?
}