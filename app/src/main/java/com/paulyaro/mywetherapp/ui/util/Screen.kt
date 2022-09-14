package com.paulyaro.mywetherapp.ui.util

sealed class Screen(val route: String) {
    object ChooseCityScreen : Screen("choose_city_screen")
    object WeatherScreen : Screen("weather_city_screen/")
}
