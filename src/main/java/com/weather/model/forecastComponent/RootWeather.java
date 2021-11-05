package com.weather.model.forecastComponent;

import java.util.List;

public class RootWeather {

    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private List<Daily> daily;

    public double getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(int timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }
}
