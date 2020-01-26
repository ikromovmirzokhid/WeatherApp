package com.imb.weatherapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imb.weatherapp.R
import com.imb.weatherapp.di.component.ActivityComponent
import com.imb.weatherapp.di.component.DaggerActivityComponent
import com.imb.weatherapp.di.module.ActivityModule
import com.imb.weatherapp.ui.weather.WeatherDetailsFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    private lateinit var activityComponent: ActivityComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependencies()

        presenter.attach(this)
    }

    private fun injectDependencies() {
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this)).build()

        activityComponent.inject(this)
    }

    override fun showCurrentWeatherDetails() {
        supportFragmentManager.beginTransaction().disallowAddToBackStack()
            .replace(R.id.container, WeatherDetailsFragment.create()).commit()
    }
}
