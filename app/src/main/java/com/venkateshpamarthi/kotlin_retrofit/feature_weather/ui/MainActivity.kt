package com.venkateshpamarthi.kotlin_retrofit.feature_weather.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.venkateshpamarthi.kotlin_retrofit.R
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.viewmodel.WeatherViewModelFactory
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.util.*


class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val viewModelFactory: WeatherViewModelFactory by instance()
    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(WeatherViewModel::class.java)
    }
    lateinit var countingIdlingResource: CountingIdlingResource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countingIdlingResource = CountingIdlingResource("MainActivity")
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        countingIdlingResource.increment()
        viewModel.fetchWeather(Locale.getDefault().country).observe(this, Observer {
            text.text = it?.location?.name
            text.visibility = View.VISIBLE
            progressbar.visibility = View.GONE
            countingIdlingResource.decrement()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
