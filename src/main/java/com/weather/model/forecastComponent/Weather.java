package com.weather.model.forecastComponent;

import com.weather.model.City;
import com.fasterxml.jackson.annotation.*;

public class Weather {
    private String cod;
    private long message;
    private long cnt;
    private ListOfComponents[] list;
    private CityForecast city;

    @JsonProperty("cod")
    public String getCod() { return cod; }
    @JsonProperty("cod")
    public void setCod(String value) { this.cod = value; }

    @JsonProperty("message")
    public long getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(long value) { this.message = value; }

    @JsonProperty("cnt")
    public long getCnt() { return cnt; }
    @JsonProperty("cnt")
    public void setCnt(long value) { this.cnt = value; }

    @JsonProperty("list")
    public ListOfComponents[] getList() { return list; }
    @JsonProperty("list")
    public void setList(ListOfComponents[] value) { this.list = value; }

    @JsonProperty("city")
    public CityForecast getCity() { return city; }
    @JsonProperty("city")
    public void setCity(CityForecast value) { this.city = value; }
}