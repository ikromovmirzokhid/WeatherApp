package com.imb.weatherapp.ui.weather

import android.util.Log
import com.imb.weatherapp.api.WeatherServiceApi
import com.imb.weatherapp.di.component.DaggerFragmentComponent
import com.imb.weatherapp.di.component.FragmentComponent
import com.imb.weatherapp.di.module.FragmentModule
import com.imb.weatherapp.models.CurrentWeatherDetails
import com.imb.weatherapp.models.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherDetailsPresenter : WeatherDetailsContract.Preseneter {
    @Inject
    constructor()

    private lateinit var view: WeatherDetailsContract.View
    private lateinit var apiService: WeatherServiceApi
    private lateinit var fragmentComponent: FragmentComponent

    override fun loadData() {

        view.showProgress(true)
        var call: Call<WeatherResponse> =
            apiService.getCurrentWeather("ca67647fdbdef648292beb7b7f4c2a53", "Tashkent")
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("FailureOccurred", t.message)
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.code() == 200) {
                    var weatherDetails = response.body()

                    if (weatherDetails != null) {
                        view.loadDataSuccess(
                            CurrentWeatherDetails(
                                weatherDetails.location.country,
                                weatherDetails.location.region,
                                weatherDetails.location.localtime,
                                weatherDetails.currentWeather.temperature,
                                weatherDetails.currentWeather.weatherIcon.get(0),
                                weatherDetails.currentWeather.weatherDescriptions.get(0),
                                weatherDetails.currentWeather.humidity,
                                weatherDetails.currentWeather.pressure,
                                weatherDetails.currentWeather.windSpeed
                            )
                        )
                    }
                    view.showProgress(false)

                }
            }
        })
    }

    override fun attach(view: WeatherDetailsContract.View) {
        this.view = view
        fragmentComponent =
            DaggerFragmentComponent.builder().fragmentModule(FragmentModule()).build()
        apiService = fragmentComponent.getApiService()
    }
}