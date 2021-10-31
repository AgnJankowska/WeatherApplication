package com.weather.model.forecastComponent;

import com.fasterxml.jackson.annotation.*;

public class Coord {
    private double lat;
    private double lon;

    @JsonProperty("lat")
    public double getLat() { return lat; }
    @JsonProperty("lat")
    public void setLat(double value) { this.lat = value; }

    @JsonProperty("lon")
    public double getLon() { return lon; }
    @JsonProperty("lon")
    public void setLon(double value) { this.lon = value; }
}
