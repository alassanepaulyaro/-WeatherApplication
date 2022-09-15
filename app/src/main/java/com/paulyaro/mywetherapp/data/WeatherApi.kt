package com.paulyaro.mywetherapp.data

import com.paulyaro.mywetherapp.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeatherForCity(
        @Query("q") city: String,
        @Query("appid") apiKey: String = BuildConfig.API_KEY,
        @Query("units") units: String = "metric"
    ) : Response<CityWeather>
}