package com.venkateshpamarthi.kotlin_retrofit

import android.app.Application
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.WeatherRepository
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.repostiory.WeatherRepositoryImpl
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.viewmodel.WeatherViewModelFactory
import com.venkateshpamarthi.kotlin_retrofit.network.WeatherService
import com.venkateshpamarthi.kotlin_retrofit.network.AppRetrofit
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AppApplication: Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        bind<WeatherService>() with singleton { AppRetrofit.getInstance().create(WeatherService::class.java) }
        bind<WeatherRepository>() with provider { WeatherRepositoryImpl(instance()) }
        bind() from provider { WeatherViewModelFactory(instance()) }
    }
}