package com.weather.model;

import com.weather.model.forecastComponent.RootWeather;
import java.io.IOException;

public class WeatherForecastManager {

    private final RootWeather weatherObject;

    public WeatherForecastManager(RootWeather weatherObject) throws IOException {
        this.weatherObject = weatherObject;
    }

    public RootWeather getWeatherObject() {
        return weatherObject;
    }
}
