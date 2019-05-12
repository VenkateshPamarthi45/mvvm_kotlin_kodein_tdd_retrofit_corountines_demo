package com.venkateshpamarthi.kotlin_retrofit.network

import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.model.ResponseModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("http://www.mocky.io/v2/5cd40c22350000de307a52b9")
    fun getCurrentWeather(
        @Query("key") key :String = "xxxx",
        @Query("q") location: String,
        @Query("lang") languageCode: String = "en"
    ): Deferred<Response<ResponseModel>>
}