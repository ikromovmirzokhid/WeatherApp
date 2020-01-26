package com.imb.weatherapp.ui.main

import com.imb.weatherapp.ui.base.BaseContract

class MainContract {

    interface Presenter : BaseContract.Presenter<View>

    interface View  {
        fun showCurrentWeatherDetails()
    }
}