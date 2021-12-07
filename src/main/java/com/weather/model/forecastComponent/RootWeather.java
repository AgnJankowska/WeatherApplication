package com.weather.model.forecastComponent;

import java.util.List;

public class RootWeather {

    private final List<Daily> daily;

    public RootWeather(List<Daily> daily) {
        this.daily = daily;
    }

    public List<Daily> getDaily() {
        return daily;
    }
}
