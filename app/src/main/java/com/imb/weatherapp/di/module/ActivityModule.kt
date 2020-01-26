package com.imb.weatherapp.di.module

import android.app.Activity
import com.imb.weatherapp.ui.main.MainContract
import com.imb.weatherapp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivityContext(): Activity = activity

    @Singleton
    @Provides
    fun provideMainActivityPresenter(): MainContract.Presenter = MainPresenter()
}