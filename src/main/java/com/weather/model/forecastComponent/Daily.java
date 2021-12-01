package com.weather.model.forecastComponent;

import java.util.List;

public class Daily {

    private Temp temp;
    private List<Weather> weather;

    public Temp getTemp() {
        return temp;
    }
    public List<Weather> getWeather() {
        return weather;
    }
}
