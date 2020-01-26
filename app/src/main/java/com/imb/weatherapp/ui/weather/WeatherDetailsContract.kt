package com.imb.weatherapp.ui.weather

import com.imb.weatherapp.models.CurrentWeatherDetails
import com.imb.weatherapp.ui.base.BaseContract

class WeatherDetailsContract {

    interface View {
        fun showProgress(show: Boolean)
        fun loadDataSuccess(details: CurrentWeatherDetails)
    }

    interface Preseneter : BaseContract.Presenter<WeatherDetailsContract.View> {
        fun loadData()
    }
}