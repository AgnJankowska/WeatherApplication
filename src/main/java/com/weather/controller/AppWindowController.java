package com.weather.controller;

import com.weather.model.JSONReader;
import com.weather.model.AutoCompleteComboBoxListener;
import com.weather.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class AppWindowController implements Initializable {

    protected ViewFactory viewFactory;
    private String fxmlName;
    private JSONReader jsonReader;
    private ArrayList<String> cities;
    private ArrayList<String> countries;

    public AppWindowController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
        this.jsonReader = new JSONReader();
        this.countries = jsonReader.getCountriesArray();
    }

    public String getFxmlName() {
        return fxmlName;
    }

    @FXML
    private ComboBox<String> comboBoxCountries1;

    @FXML
    private ComboBox<String> comboBoxCities1;

    @FXML
    private TextField country1;

    @FXML
    private TextField city1;

    @FXML
    private TextField country2;

    @FXML
    private TextField city2;

    @FXML
    void buttonAction() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        addCountries();
        comboBoxCountries1.setOnAction(e -> addCities());

        new AutoCompleteComboBoxListener<>(comboBoxCountries1);
        new AutoCompleteComboBoxListener<>(comboBoxCities1);
    }

    private void addCountries() {
        ObservableList<String> observableListCountries = FXCollections.observableList(countries);
        comboBoxCountries1.setItems(observableListCountries);
    }

    private void addCities() {
        comboBoxCities1.setVisible(true);
        comboBoxCities1.getItems().clear();

        String selectedCountry = comboBoxCountries1.getSelectionModel().selectedItemProperty().getValue();
        cities = jsonReader.getCitiesOfSelectedCountry(selectedCountry);
        Collections.sort(cities);

        ObservableList<String> observableListCities = FXCollections.observableList(cities);
        comboBoxCities1.setItems(observableListCities);
    }
}
