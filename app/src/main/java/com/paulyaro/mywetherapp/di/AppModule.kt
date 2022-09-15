package com.paulyaro.mywetherapp.di

import com.paulyaro.mywetherapp.Repository.WeatherRepository
import com.paulyaro.mywetherapp.data.WeatherApi
import com.paulyaro.mywetherapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerWeatherApi(): WeatherApi =
         Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)

    @Singleton
    @Provides
    fun providerWeatherRepository(weatherApi: WeatherApi) = WeatherRepository(weatherApi)
}