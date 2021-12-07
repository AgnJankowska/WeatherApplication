package com.weather.model.service;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.weather.App;
import com.weather.model.City;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitiesListService extends Service<List<City>> {

    private final URL url = this.getClass().getResource("cities.json");
    private static final Gson GSON = new Gson();

    @Override
    protected Task<List<City>> createTask() {
        return new Task<>() {
            @Override
            protected List<City> call() {
                return createCityListFromJSON();
            }
        };
    }

    protected List<City> createCityListFromJSON() {
        List<City> cities;

        try {
            assert url != null;
            Scanner content = new Scanner((InputStream) url.getContent(), StandardCharsets.UTF_8);
            StringBuilder result = new StringBuilder();
            while (content.hasNext()) {
                result.append(content.nextLine());
            }
            String json = result.toString();

            Type userListType = new TypeToken<ArrayList<City>>() {}.getType();
            cities = GSON.fromJson(json, userListType);
            return cities;

        } catch (IOException e) {
            App.showErrorMessage("Brak połączenia z pikiem cities.json.");
        }
        return null;
    }
}