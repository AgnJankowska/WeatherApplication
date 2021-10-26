package com.weather.controller;

import com.weather.JSONReader;
import com.weather.model.AutoCompleteComboBoxListener;
import com.weather.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AppWindowController implements Initializable {

    protected ViewFactory viewFactory;
    private String fxmlName;
    private  JSONReader jsonReader;
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

        new AutoCompleteComboBoxListener<>(comboBoxCountries1);
        new AutoCompleteComboBoxListener<>(comboBoxCities1);

        addCountries();
        comboBoxCountries1.setOnAction(e -> addCities());
    }

    private void addCountries() {
        for(int i =0; i < countries.size(); i++) {
            comboBoxCountries1.getItems().add(countries.get(i));
        }
    }

    private void addCities() {
        comboBoxCities1.setVisible(true);
        comboBoxCities1.getItems().clear();

        String selectedCountry = comboBoxCountries1.getSelectionModel().selectedItemProperty().getValue();
        cities = jsonReader.getCitiesOfSelectedCountry(selectedCountry);

        for(int i =0; i < cities.size(); i++) {
            comboBoxCities1.getItems().add(cities.get(i));
        }
    }


}
