package com.weather.model.forecastComponent;

import com.fasterxml.jackson.annotation.*;

public class CityForecast {
    private long id;
    private String name;
    private Coord coord;
    private String country;
    private long population;
    private long timezone;
    private long sunrise;
    private long sunset;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("coord")
    public Coord getCoord() { return coord; }
    @JsonProperty("coord")
    public void setCoord(Coord value) { this.coord = value; }

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("population")
    public long getPopulation() { return population; }
    @JsonProperty("population")
    public void setPopulation(long value) { this.population = value; }

    @JsonProperty("timezone")
    public long getTimezone() { return timezone; }
    @JsonProperty("timezone")
    public void setTimezone(long value) { this.timezone = value; }

    @JsonProperty("sunrise")
    public long getSunrise() { return sunrise; }
    @JsonProperty("sunrise")
    public void setSunrise(long value) { this.sunrise = value; }

    @JsonProperty("sunset")
    public long getSunset() { return sunset; }
    @JsonProperty("sunset")
    public void setSunset(long value) { this.sunset = value; }
}
