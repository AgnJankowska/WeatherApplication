package com.weather.model;

import com.weather.model.forecastComponent.RootWeather;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherForecastManager {

    private RootWeather weatherObject;

    public WeatherForecastManager(Double longitude, Double latitude) throws IOException {
        JSONReaderWeather jsonReaderWeather = new JSONReaderWeather(longitude, latitude);
        this.weatherObject = jsonReaderWeather.createObjectFromJSON();
    }

    public ArrayList<String> getArrayOfTemperature() {
        int maxTemperature;
        ArrayList<String> arrayOfTemperature = new ArrayList<String>(5);

        int i=0;
        while(i < 5){
            maxTemperature = (int)Math.round(weatherObject.getDaily().get(i).getTemp().getMax());
            arrayOfTemperature.add(maxTemperature+"");
            i++;
        }
        return arrayOfTemperature;
    }



}
