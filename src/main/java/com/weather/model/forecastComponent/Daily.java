package com.weather.model.forecastComponent;

import java.util.List;

public class Daily {

    private final Temp temp;
    private final List<Weather> weather;

    public Daily(Temp temp, List<Weather> weather) {
        this.temp = temp;
        this.weather = weather;
    }

    public Temp getTemp() {
        return temp;
    }
    public List<Weather> getWeather() {
        return weather;
    }
}
