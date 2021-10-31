package com.weather.model.forecastComponent;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class ListOfComponents {
    private long dt;
    private MainClass main;
    private WeatherElement[] weather;
    private Clouds clouds;
    private Wind wind;
    private long visibility;
    private double pop;
    private Sys sys;
    private OffsetDateTime dtTxt;
    private Rain rain;

    @JsonProperty("dt")
    public long getDt() { return dt; }
    @JsonProperty("dt")
    public void setDt(long value) { this.dt = value; }

    @JsonProperty("main")
    public MainClass getMain() { return main; }
    @JsonProperty("main")
    public void setMain(MainClass value) { this.main = value; }

    @JsonProperty("weather")
    public WeatherElement[] getWeather() { return weather; }
    @JsonProperty("weather")
    public void setWeather(WeatherElement[] value) { this.weather = value; }

    @JsonProperty("clouds")
    public Clouds getClouds() { return clouds; }
    @JsonProperty("clouds")
    public void setClouds(Clouds value) { this.clouds = value; }

    @JsonProperty("wind")
    public Wind getWind() { return wind; }
    @JsonProperty("wind")
    public void setWind(Wind value) { this.wind = value; }

    @JsonProperty("visibility")
    public long getVisibility() { return visibility; }
    @JsonProperty("visibility")
    public void setVisibility(long value) { this.visibility = value; }

    @JsonProperty("pop")
    public double getPop() { return pop; }
    @JsonProperty("pop")
    public void setPop(double value) { this.pop = value; }

    @JsonProperty("sys")
    public Sys getSys() { return sys; }
    @JsonProperty("sys")
    public void setSys(Sys value) { this.sys = value; }

    @JsonProperty("dt_txt")
    public OffsetDateTime getDtTxt() { return dtTxt; }
    @JsonProperty("dt_txt")
    public void setDtTxt(OffsetDateTime value) { this.dtTxt = value; }

    @JsonProperty("rain")
    public Rain getRain() { return rain; }
    @JsonProperty("rain")
    public void setRain(Rain value) { this.rain = value; }
}
