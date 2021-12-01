package com.weather.model.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.weather.App;
import com.weather.model.Country;
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

public class CountriesListService extends Service<List<Country>> {

    private final URL url = this.getClass().getResource("countries.json");
    private static final Gson GSON = new Gson();

    @Override
    protected Task<List<Country>> createTask() {
        return new Task<>() {
            @Override
            protected List<Country> call() {
                return createCountryListFromJSON();
            }
        };
    }

    private List<Country> createCountryListFromJSON() {
        List<Country> countries;
        try {
            assert url != null;
            Scanner content = new Scanner((InputStream) url.getContent(), StandardCharsets.UTF_8);
            StringBuilder result = new StringBuilder();
            while (content.hasNext()) {
                result.append(content.nextLine());
            }
            String json = result.toString();

            Type userListType = new TypeToken<ArrayList<Country>>(){}.getType();
            countries = GSON.fromJson(json, userListType);
            return countries;

        } catch (IOException e) {
            App.showErrorMessage("Brak połączenia z pikiem countries.json.");
        }
        return null;
    }
}
