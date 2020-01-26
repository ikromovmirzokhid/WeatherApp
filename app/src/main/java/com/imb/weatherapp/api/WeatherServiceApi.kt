package com.imb.weatherapp.api

import com.imb.weatherapp.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServiceApi {

    @GET("current")
    fun getCurrentWeather(@Query("access_key") accessKey: String, @Query("query") query: String): Call<WeatherResponse>

    companion object {
        val BASE_URL = "http://api.weatherstack.com/"
    }
}