package com.weather.model.service;

import com.google.gson.Gson;
import com.weather.App;
import com.weather.model.URLWeather;
import com.weather.model.forecastComponent.RootWeather;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WeatherService extends Service<RootWeather> {

    private final String createURLString;
    private static final Gson GSON = new Gson();
    private final URL url;

    @Override
    protected Task<RootWeather> createTask() {
        return new Task<>() {
            @Override
            protected RootWeather call() throws Exception {
                return new WeatherTask(url).call();
            }
        };
    }

    public WeatherService(Double longitude, Double latitude) throws MalformedURLException {
        URLWeather createURL = new URLWeather(longitude, latitude);
        this.createURLString = createURL.getUrl();
        this.url = new URL(createURLString);
    }

    public static class WeatherTask extends Task<RootWeather> {
        private final URL url;

        public WeatherTask(URL url) {
            this.url = url;
        }

        @Override
        protected RootWeather call() {
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
}
