package com.paulyaro.mywetherapp.ui.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paulyaro.mywetherapp.ui.chooseCity.ChooseCityScreen
import com.paulyaro.mywetherapp.ui.weatherCity.WeatherScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ChooseCityScreen.route) {

        composable(Screen.ChooseCityScreen.route) {
            ChooseCityScreen(navController = navController)
        }

        composable(Screen.WeatherScreen.route + "{city}") { navBackStackEntry ->
            val city = navBackStackEntry.arguments?.getString("city") ?: "Paris"
            WeatherScreen(city = city)
        }
    }
}
