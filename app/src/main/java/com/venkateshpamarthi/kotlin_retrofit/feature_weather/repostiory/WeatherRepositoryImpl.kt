package com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory

import android.support.annotation.WorkerThread
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.model.ResponseModel
import com.venkateshpamarthi.kotlin_retrofit.network.WeatherService

class WeatherRepositoryImpl(private val service: WeatherService) : WeatherRepository {

    @WorkerThread
    override suspend fun getWeatherDetails(countryCode: String): ResponseModel? {
        val result = service.getCurrentWeather(location = countryCode).await()
        return result.body()
    }
}