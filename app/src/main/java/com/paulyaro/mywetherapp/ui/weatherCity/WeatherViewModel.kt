package com.paulyaro.mywetherapp.ui.weatherCity

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulyaro.mywetherapp.Repository.WeatherRepository
import com.paulyaro.mywetherapp.data.CityWeather
import com.paulyaro.mywetherapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository):ViewModel() {

    private val _cityWeather = mutableStateOf<Resource<CityWeather>>(Resource.loading(null))
    var cityWeather :State<Resource<CityWeather>> = _cityWeather

    fun submitCity(cityName:String) {
        viewModelScope.launch {
            _cityWeather.value = weatherRepository.getWeatherForCity(city = cityName)
        }
    }
}