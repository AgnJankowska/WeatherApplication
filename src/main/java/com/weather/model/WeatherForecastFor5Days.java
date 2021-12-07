package com.weather.model;

import com.weather.model.forecastComponent.RootWeather;
import com.weather.model.weatherCondition.DescriptionOfCondition;
import com.weather.model.weatherCondition.MainCondition;
import com.weather.model.weatherCondition.SingleCondition;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastFor5Days {

    private final int numberOfDayInForecast = 5;
    private final int numberOfTypeOfDescription = 54;

    public List<String> getArrayOfTemperature(RootWeather weatherObject) {
        int maxTemperature;
        List<String> arrayOfTemperature = new ArrayList<>(numberOfDayInForecast);

        int i = 0;
        while (i < numberOfDayInForecast) {
            maxTemperature = (int) Math.round(weatherObject.getDaily().get(i).getTemp().getMax());
            arrayOfTemperature.add(String.valueOf(maxTemperature));
            i++;
        }
        return arrayOfTemperature;

    }

    public List<MainCondition> getArrayOfConditions(RootWeather weatherObject) {
        int idCondition;
        MainCondition condition;
        List<MainCondition> arrayOfConditions =  new ArrayList<>(numberOfDayInForecast);
        List<SingleCondition> arraySingleCondition = initializeArrayOfCondition();

        for(int i=0; i<numberOfDayInForecast; i++){
            idCondition = weatherObject.getDaily().get(i).getWeather().get(0).getId();
            for(int j=0; j<numberOfTypeOfDescription; j++){
                if(idCondition == arraySingleCondition.get(j).getId()){
                    condition = arraySingleCondition.get(j).getMain();
                    arrayOfConditions.add(condition);
                }
            }
        }
        return arrayOfConditions;
    }

    public List<String> getArrayOfDescription(RootWeather weatherObject) {
        String description;
        int condition;
        List<String> arrayOfDescription =  new ArrayList<>(numberOfDayInForecast);
        List<SingleCondition> arraySingleCondition = initializeArrayOfCondition();

        for(int i=0; i<numberOfDayInForecast; i++){
            condition = weatherObject.getDaily().get(i).getWeather().get(0).getId();
            for(int j=0; j<numberOfTypeOfDescription; j++){
                if(condition == arraySingleCondition.get(j).getId()){
                    description = arraySingleCondition.get(j).getDescription();
                    arrayOfDescription.add(description);
                }
            }
        }
        return arrayOfDescription;
    }

    private List<SingleCondition> initializeArrayOfCondition() {
        DescriptionOfCondition descriptionOfCondition = new DescriptionOfCondition();
        return descriptionOfCondition.getArrayOfCondition();
    }
}
