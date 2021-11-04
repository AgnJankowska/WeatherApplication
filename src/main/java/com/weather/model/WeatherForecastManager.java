package com.weather.model;

import com.weather.model.forecastComponent.RootWeather;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherForecastManager {

    private RootWeather weatherObject;

    public WeatherForecastManager() {}
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

    public ArrayList<Integer> getArrayOfConditions() {
        Integer condition;
        ArrayList<Integer> arrayOfConditions = new ArrayList<>(5);

        int i=0;
        while(i < 5){
            condition = weatherObject.getDaily().get(i).getWeather().get(0).getId();
            arrayOfConditions.add(condition);
            i++;
        }
        return arrayOfConditions;
    }

    public Image getGraphic(int position) {
        ArrayList<Integer> arrayOfConditions = getArrayOfConditions();
        WeatherConditionGraphic weatherConditionGraphic = new WeatherConditionGraphic();
        return weatherConditionGraphic.getConditionGraphic(arrayOfConditions, position);
    }

    public Image getInitialGraphic() {
        WeatherConditionGraphic weatherConditionGraphic = new WeatherConditionGraphic();
        return weatherConditionGraphic.getInitialGraphic();
    }
}
