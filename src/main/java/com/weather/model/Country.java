package com.weather.model;

public class Country {

    private final String name;
    private final Integer id;
    private final Double latitude;
    private final Double longitude;

    public Country(String name, Integer id, Double latitude, Double longitude) {
        this.name = name;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

}
