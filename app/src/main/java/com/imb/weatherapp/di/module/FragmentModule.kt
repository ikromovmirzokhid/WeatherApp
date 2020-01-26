package com.imb.weatherapp.di.module

import com.imb.weatherapp.api.WeatherServiceApi
import com.imb.weatherapp.ui.weather.WeatherDetailsPresenter
import com.imb.weatherapp.ui.weather.WeatherDetailsContract
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class FragmentModule {

    @Provides
    fun provideFragmentPresenter():  WeatherDetailsContract.Preseneter = WeatherDetailsPresenter()

    @Provides
    fun provideApiService(retrofit: Retrofit): WeatherServiceApi =
        retrofit.create(WeatherServiceApi::class.java)

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(WeatherServiceApi.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).client(okHttpClient).build()

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

}