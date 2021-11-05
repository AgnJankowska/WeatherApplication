package com.weather.model.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountriesObservableListService extends Service<ObservableList<String>> {

    private String urlCounties = "src/main/resources/com/weather/model/countries.json";

    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                ObservableList<String> countriesObservableList = FXCollections.observableList(createListOfCountries());
                return countriesObservableList;
            }
        };
    }

    private List<String> createListOfCountries() {
        List<String> countriesList = new ArrayList<String>();
        try {
            String contents = new String((Files.readAllBytes(Paths.get(urlCounties))));
            JSONArray allContent = new JSONArray(contents);
            for (int i = 0; i < allContent.length(); i++) {
                countriesList.add((String) allContent.getJSONObject(i).get("name"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countriesList;
    }
}
