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

    @FXML
    private Label temp11;

    @FXML
    private Label temp12;

    @FXML
    private Label temp13;

    @FXML
    private Label temp14;

    @FXML
    private Label temp15;

    @FXML
    private Label temp21;

    @FXML
    private Label temp22;

    @FXML
    private Label temp23;

    @FXML
    private Label temp24;

    @FXML
    private Label temp25;

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
        comboBoxCities.getItems().clear();
        comboBoxCities.setVisible(true);

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

    private void setDate() {
        DateHandler dateHandler = new DateHandler();

        date1.setText(dateHandler.getArrayOfFiveDays().get(0));
        date2.setText(dateHandler.getArrayOfFiveDays().get(1));
        date3.setText(dateHandler.getArrayOfFiveDays().get(2));
        date4.setText(dateHandler.getArrayOfFiveDays().get(3));
        date5.setText(dateHandler.getArrayOfFiveDays().get(4));
    }

    private void showWeather(ComboBox<String> comboBoxCities) {
        City city;

        try {
            city = getCoordinate(comboBoxCities);
            WeatherForecastManager weatherForecastManager = new WeatherForecastManager(city.getLongitude(), city.getLatitude());

            setTemperature(weatherForecastManager, comboBoxCities);

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void setTemperature(WeatherForecastManager weatherForecastManager, ComboBox<String> comboBoxCities) {

        if(comboBoxCities.getId().equals("comboBoxCities1")) {
            temp11.setText(weatherForecastManager.getArrayOfTemperature().get(0) + '\u00B0' + "C");
            temp12.setText(weatherForecastManager.getArrayOfTemperature().get(1) + '\u00B0' + "C");
            temp13.setText(weatherForecastManager.getArrayOfTemperature().get(2) + '\u00B0' + "C");
            temp14.setText(weatherForecastManager.getArrayOfTemperature().get(3) + '\u00B0' + "C");
            temp15.setText(weatherForecastManager.getArrayOfTemperature().get(4) + '\u00B0' + "C");
        }
        else if(comboBoxCities.getId().equals("comboBoxCities2")) {
            temp21.setText(weatherForecastManager.getArrayOfTemperature().get(0) + '\u00B0' + "C");
            temp22.setText(weatherForecastManager.getArrayOfTemperature().get(1) + '\u00B0' + "C");
            temp23.setText(weatherForecastManager.getArrayOfTemperature().get(2) + '\u00B0' + "C");
            temp24.setText(weatherForecastManager.getArrayOfTemperature().get(3) + '\u00B0' + "C");
            temp25.setText(weatherForecastManager.getArrayOfTemperature().get(4) + '\u00B0' + "C");
        }
    }

    private void setGraphic(WeatherForecastManager weatherForecastManager) {


    }
}
