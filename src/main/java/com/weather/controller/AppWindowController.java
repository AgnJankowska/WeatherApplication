package com.weather.controller;

import com.weather.model.*;
import com.weather.model.auxiliaryClasses.AutoCompleteComboBoxListener;
import com.weather.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class AppWindowController implements Initializable {

    protected ViewFactory viewFactory;
    private String fxmlName;
    private JSONReaderLocation jsonReader;
    private ArrayList<String> citiesName;
    private ArrayList<City> cities;
    private ArrayList<String> countries;

    public AppWindowController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
        this.jsonReader = new JSONReaderLocation();
        this.countries = jsonReader.getCountriesArray();
        this.cities = new ArrayList<City>();
        this.citiesName = new ArrayList<String>();
    }

    public String getFxmlName() {
        return fxmlName;
    }

    @FXML
    private ComboBox<String> comboBoxCountries1;

    @FXML
    private ComboBox<String> comboBoxCities1;

    @FXML
    private ComboBox<String> comboBoxCountries2;

    @FXML
    private ComboBox<String> comboBoxCities2;

    @FXML
    private Label date1;

    @FXML
    private Label date2;

    @FXML
    private Label date3;

    @FXML
    private Label date4;

    @FXML
    private Label date5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCountries(comboBoxCountries1);
        addCountries(comboBoxCountries2);
        setDate();
        comboBoxCountries1.setOnAction(e -> addCities(comboBoxCities1, comboBoxCountries1));
        comboBoxCountries2.setOnAction(e -> addCities(comboBoxCities2, comboBoxCountries2));
        comboBoxCities1.setOnAction(e -> showWeather(comboBoxCities1));
        comboBoxCities2.setOnAction(e -> showWeather(comboBoxCities2));
    }

    private void addCountries(ComboBox<String> comboBoxCountries) {
        ObservableList<String> observableListCountries = FXCollections.observableList(countries);
        comboBoxCountries.setItems(observableListCountries);

        new AutoCompleteComboBoxListener<>(comboBoxCountries);
    }

    private void addCities(ComboBox<String> comboBoxCities, ComboBox<String> comboBoxCountries) {
        comboBoxCities.setVisible(true);
        comboBoxCities.getItems().clear();

        String selectedCountry = comboBoxCountries.getSelectionModel().selectedItemProperty().getValue();
        cities = jsonReader.getCitiesOfSelectedCountry(selectedCountry);

        int i = 0;
        while(i < cities.size()) {
            citiesName.add(cities.get(i).getName());
            i++;
        }
        Collections.sort(citiesName);

        ObservableList<String> observableListCities = FXCollections.observableList(citiesName);
        comboBoxCities.setItems(observableListCities);

        new AutoCompleteComboBoxListener<>(comboBoxCities);
    }

    private City getCoordinate(ComboBox<String> comboBoxCities) throws IOException {
        City city = new City();

        int i=0;
        while(i<cities.size()){
            if(comboBoxCities.getSelectionModel().selectedItemProperty().getValue().equals(cities.get(i).getName())){
                city.setName(cities.get(i).getName());
                city.setId(cities.get(i).getId());
                city.setLatitude(cities.get(i).getLatitude());
                city.setLongitude(cities.get(i).getLongitude());
            }
            i++;
        }
        return city;
    }

    private void showWeather(ComboBox<String> comboBoxCities) {
        City city = new City();

        try {
            city = getCoordinate(comboBoxCities);
            WeatherForecastManager weatherForecastManager = new WeatherForecastManager(city.getLongitude(), city.getLatitude());
            weatherForecastManager.getWeather();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDate() {
        DateHandler dateHandler = new DateHandler();

        date1.setText(dateHandler.getArrayOfFiveDays().get(0));
        date2.setText(dateHandler.getArrayOfFiveDays().get(1));
        date3.setText(dateHandler.getArrayOfFiveDays().get(2));
        date4.setText(dateHandler.getArrayOfFiveDays().get(3));
        date5.setText(dateHandler.getArrayOfFiveDays().get(4));
    }
}
