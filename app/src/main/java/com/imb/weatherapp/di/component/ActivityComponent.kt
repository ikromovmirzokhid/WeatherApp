package com.imb.weatherapp.di.component

import com.imb.weatherapp.di.module.ActivityModule
import com.imb.weatherapp.ui.main.MainActivity
import com.imb.weatherapp.ui.main.MainContract
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun getMainActiivtyPresenter(): MainContract.Presenter

    fun inject(activity: MainActivity)
}