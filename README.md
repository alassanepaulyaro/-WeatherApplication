# WeatherApplication

WeatherApplication is a mobile application designed to display real-time weather information. It provides data such as temperature, pressure, humidity, and current weather descriptions for a specified location.

## Table of Contents

1. Project Overview
2. Features
3. Configuration
4. Author

### Project Overview

The goal of this project is to provide a foundation for a simple yet effective weather app. It leverages a third-party weather API (e.g., OpenWeatherMap or a similar service) to fetch the necessary data.

### Features

- Fetch weather data (temperature, pressure, humidity, sky description, etc.).
- Support for geographic location (or manual city input).
- Display of icons or images that match the current weather conditions.
- Ability to refresh weather data to get the most recent information.
- Simple and clean user interface.

### Configuration

1. API Key:

- Obtain an API key (free or paid) from your weather data provider (OpenWeatherMap, WeatherAPI, etc.).
- Locate where in the code this API key should be added (often in a Constants, config, or BuildConfig file).
- Insert your API key so the application can fetch weather data.

2. Permissions:

- Make sure the required permissions (e.g., location) are declared in the AndroidManifest.xml file and/or requested at runtime (depending on the Android version).

### Author
Alassane Paulyaro – GitHub
If you have any questions, issues, or suggestions, feel free to open an issue.

### Screenshot


<img src="Screenshot_home_my_weather_app.png" alt="Alt Text" width="393" height="852">

<img src="Screenshot_Detail_my_weather_app.png" alt="Alt Text" width="393" height="852">

