package com.weather.model.forecastComponent;

import com.fasterxml.jackson.annotation.*;

public class Rain {
    private double the3H;

    @JsonProperty("3h")
    public double getThe3H() { return the3H; }
    @JsonProperty("3h")
    public void setThe3H(double value) { this.the3H = value; }
}
