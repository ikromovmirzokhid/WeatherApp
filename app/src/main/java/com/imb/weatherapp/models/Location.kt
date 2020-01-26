package com.imb.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("region") val region: String,
    @SerializedName("lat") val lat: String,
    @SerializedName("lon") val lon: String,
    @SerializedName("timezone_id") val timezoneId: String,
    @SerializedName("localtime") val localtime: String,
    @SerializedName("localtime_epoch") val localtimeEpoch: Int,
    @SerializedName("utc_offset") val utcOffset: Float
)