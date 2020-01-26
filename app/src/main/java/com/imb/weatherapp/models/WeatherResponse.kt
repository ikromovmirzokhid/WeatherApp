package com.imb.weatherapp.models

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("request") val request: Request,
    @SerializedName("location") val location: Location,
    @SerializedName("current") val currentWeather: Current
)