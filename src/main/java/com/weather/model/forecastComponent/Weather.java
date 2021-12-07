package com.weather.model.forecastComponent;
import com.weather.model.weatherCondition.DescriptionOfCondition;

public class Weather {

    private final int id;

    public Weather(int id) {
        this.id = id;
    }

    public int getId() {
        DescriptionOfCondition descriptionOfCondition = new DescriptionOfCondition();
        if(descriptionOfCondition.idIsCorrect(id)) {
            return id;
        } else {
            throw new IllegalStateException();
        }
    }
}
