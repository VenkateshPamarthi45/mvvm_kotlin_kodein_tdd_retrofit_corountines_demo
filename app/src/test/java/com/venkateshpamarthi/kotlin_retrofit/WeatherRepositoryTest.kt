package com.venkateshpamarthi.kotlin_retrofit


import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.WeatherRepositoryImpl
import com.venkateshpamarthi.kotlin_retrofit.network.WeatherService
import com.venkateshpamarthi.kotlin_retrofit.network.AppRetrofit
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Test
import java.util.*

class WeatherRepositoryTest {

    @Test
    fun getWeather()= runBlocking{
        val result = WeatherRepositoryImpl(AppRetrofit.getInstance().create(WeatherService::class.java)).getWeatherDetails(Locale.getDefault().country)
        println("result " + result.toString())
        Assert.assertEquals(1009,result?.current?.condition?.code)
        Assert.assertEquals("Overcast",result?.current?.condition?.text)
    }

}