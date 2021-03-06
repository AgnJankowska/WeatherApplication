package com.weather.model;

public class City {

    private final String name;
    private final Integer country_id;
    private final Double latitude;
    private final Double longitude;

    public City(String name, Integer country_id, Double latitude, Double longitude) {
        this.name = name;
        this.country_id = country_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public Integer getCountryId() {
        return country_id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
