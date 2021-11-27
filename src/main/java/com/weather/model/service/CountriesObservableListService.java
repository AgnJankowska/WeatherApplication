package com.weather.model.service;

import com.weather.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CountriesObservableListService extends Service<ObservableList<String>> {

    private URL url = this.getClass().getResource("countries.json");

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
            InputStream in = url.openStream();
            String contents = new String(in.readAllBytes());
            JSONArray allContent = new JSONArray(contents);
            for (int i = 0; i < allContent.length(); i++) {
                countriesList.add((String) allContent.getJSONObject(i).get("name"));
            }
        } catch (IOException e) {
            App.showErrorMessage("Nie znaleziono wymaganego pliku źródłowego.");
        }
        return countriesList;
    }
}
