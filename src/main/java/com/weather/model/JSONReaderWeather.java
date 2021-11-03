package com.weather.model;

import com.google.gson.Gson;
import com.weather.model.forecastComponent.RootWeather;

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

    public RootWeather createObjectFromJSON() throws IOException {
        URL url = new URL(createURLString);

        System.out.println(url);

        Scanner content = new Scanner((InputStream) url.getContent());
        String result = "";

        while (content.hasNext()) {
            result += content.nextLine();
        }

        RootWeather weatherObject = null;
        Gson gson = new Gson();
        String json = result;

        weatherObject = gson.fromJson(json, RootWeather.class);
        return weatherObject;
    }
}
