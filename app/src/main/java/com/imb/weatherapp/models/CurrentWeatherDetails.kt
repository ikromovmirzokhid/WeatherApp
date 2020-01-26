package com.imb.weatherapp.models

data class CurrentWeatherDetails(
    val country: String,
    val region: String,
    val updatedTime: String,
    val temperature: Int,
    val weatherIcon: String,
    val weatherDesc: String,
    val humidity: Int,
    val pressure: Int,
    val windSpeed: Int
)