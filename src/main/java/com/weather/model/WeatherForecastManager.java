package com.weather.model;

import com.weather.model.forecastComponent.RootWeather;

public class WeatherForecastManager {

    private final RootWeather weatherObject;

    public WeatherForecastManager(RootWeather weatherObject)  {
        this.weatherObject = weatherObject;
    }

    public RootWeather getWeatherObject() {
        return weatherObject;
    }
}
