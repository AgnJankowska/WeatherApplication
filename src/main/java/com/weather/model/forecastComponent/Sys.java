package com.weather.model.forecastComponent;

import com.fasterxml.jackson.annotation.*;

public class Sys {
    private Pod pod;

    @JsonProperty("pod")
    public Pod getPod() { return pod; }
    @JsonProperty("pod")
    public void setPod(Pod value) { this.pod = value; }
}
