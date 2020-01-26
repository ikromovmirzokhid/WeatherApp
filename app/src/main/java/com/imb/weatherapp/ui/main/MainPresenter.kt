package com.imb.weatherapp.ui.main

class MainPresenter : MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showCurrentWeatherDetails()
    }
}