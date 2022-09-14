package com.paulyaro.mywetherapp.Repository

import com.paulyaro.mywetherapp.data.CityWeather
import com.paulyaro.mywetherapp.data.WeatherApi
import com.paulyaro.mywetherapp.utils.Resource
import java.lang.Exception
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApi: WeatherApi) {

    suspend fun getWeatherForCity(city:String) :Resource<CityWeather>{
        return try {
            val response = weatherApi.getWeatherForCity(city)
            if (response.isSuccessful){
                Resource.success(response.body())
            } else {
                Resource.error(response.message(), null)
            }
        } catch (e : Exception) {
            Resource.error("Couldn't connect to  the servers. Check your internet connection", null)
        }

    }
}