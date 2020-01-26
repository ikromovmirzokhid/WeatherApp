package com.imb.weatherapp.di.component

import com.imb.weatherapp.api.WeatherServiceApi
import com.imb.weatherapp.di.module.FragmentModule
import com.imb.weatherapp.ui.weather.WeatherDetailsContract
import com.imb.weatherapp.ui.weather.WeatherDetailsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun getApiService(): WeatherServiceApi

    fun getWeatherFragmentPresenter(): WeatherDetailsContract.Preseneter

    fun inject(weatherFragment: WeatherDetailsFragment)
}