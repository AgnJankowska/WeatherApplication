package com.weather.model.service;

import com.google.gson.Gson;
import com.weather.App;
import com.weather.model.CreateURL;
import com.weather.model.forecastComponent.RootWeather;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class WeatherService extends Service<RootWeather> {

    private final String createURLString;
    private static final Gson GSON = new Gson();

    @Override
    protected Task<RootWeather> createTask() {
        return new Task<>() {
            @Override
            protected RootWeather call() throws IOException {
                return createObjectFromJSON();
            }
        };
    }

    public WeatherService(Double longitude, Double latitude) {
        CreateURL createURL = new CreateURL(longitude, latitude);
        this.createURLString = createURL.getUrl();
    }

    private RootWeather createObjectFromJSON() throws IOException {
        URL url = new URL(createURLString);
        RootWeather weatherObject;

        try {
            Scanner content = new Scanner((InputStream) url.getContent());
            StringBuilder result = new StringBuilder();

            while (content.hasNext()) {
                result.append(content.nextLine());
            }
            String json = result.toString();
            weatherObject = GSON.fromJson(json, RootWeather.class);
            return weatherObject;
        }
        catch (Exception e) {
            App.showErrorMessage("Brak połączenia z siecią. Sprawdzenie pogody jest niemożliwe.");
        }
        return null;
    }
}
