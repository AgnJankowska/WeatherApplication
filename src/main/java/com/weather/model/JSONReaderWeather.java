package com.weather.model;

import com.google.gson.Gson;
import com.weather.model.forecastComponent.Weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class JSONReaderWeather {

    private String createURLString;

    public JSONReaderWeather(Double longitude, Double latitude) {
        CreateURL createURL = new CreateURL(longitude, latitude);
        this.createURLString = createURL.getUrl();
    }

    public Weather createObjectFromJSON() throws IOException {
        URL url = new URL(createURLString);
        Scanner content = new Scanner((InputStream) url.getContent());
        String result = "";

        while (content.hasNext()) {
            result += content.nextLine();
        }

        Weather weatherObject = null;
        Gson gson = new Gson();
        String json = result;

        weatherObject = gson.fromJson(json, Weather.class);
        return weatherObject;
    }
}
