package com.paulyaro.mywetherapp.ui.weatherCity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.paulyaro.mywetherapp.R
import com.paulyaro.mywetherapp.utils.Status

@Composable
fun WeatherScreen( city : String, viewModel: WeatherViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = city) {
        viewModel.submitCity(city)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        when(viewModel.cityWeather.value.status) {
            Status.SUCCESS -> {
                Text(text = viewModel.cityWeather.value.data?.name?: city, fontSize = 48.sp)
                Image(painter = painterResource(id =
                when (
                    viewModel.cityWeather.value.data?.weather?.first()?.icon) {
                    "01d" -> R.drawable.weather01d
                    "01n" -> R.drawable.weather01n
                    "02d" -> R.drawable.weather02d
                    "02n" -> R.drawable.weather02n
                    "03d", "03n" -> R.drawable.weather03
                    "04d", "04n" -> R.drawable.weather04
                    "09d", "09n" -> R.drawable.weather09
                    "10d" -> R.drawable.weather10d
                    "10n" -> R.drawable.weather10n
                    "11d", "11n" -> R.drawable.weather11
                    "13d", "13n" -> R.drawable.weather13
                    else -> R.drawable.weather01d
                }), contentDescription = "",
                    modifier = Modifier.size(256.dp)
                )
                Text(text = "${viewModel.cityWeather.value.data?.weather?.first()?.description}",
                fontSize = 32.sp)

                Text(text = "${viewModel.cityWeather.value.data?.main?.temp}°c", fontSize = 48.sp)

                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("${viewModel.cityWeather.value.data?.main?.temp_min}°c")
                    }
                    append(" | ")
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("${viewModel.cityWeather.value.data?.main?.temp_max}°c")
                    }
                }, fontSize = 32.sp)

                Text(
                    text = "Humidity: ${viewModel.cityWeather.value.data?.main?.humidity}%",
                    fontSize = 32.sp
                )
            }
            Status.ERROR -> {
                Text(
                    text = viewModel.cityWeather.value.message ?: "An unknown error occurred!",
                    fontSize = 16.sp
                )
            }
            Status.LOADING ->{
                CircularProgressIndicator()
            }
        }
    }
}