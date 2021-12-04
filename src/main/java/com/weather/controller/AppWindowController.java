package com.weather.controller;

import com.weather.App;
import com.weather.model.*;
import com.weather.model.auxiliaryClasses.AutoCompleteComboBoxListener;
import com.weather.model.forecastComponent.RootWeather;
import com.weather.model.service.CitiesListService;
import com.weather.model.service.CountriesListService;
import com.weather.model.service.GraphicService;
import com.weather.model.service.WeatherService;
import com.weather.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AppWindowController implements Initializable {

    protected ViewFactory viewFactory;
    private final String fxmlName;
    private List<Country> countriesList;
    private List<City> citiesList;
    private WeatherForecastManager weatherForecastManager;

    public AppWindowController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }

    @FXML
    private ProgressIndicator progressBar;

    @FXML
    private Label labelToProgressBar;

    @FXML
    private WeatherForCityController weatherForCity1Controller;

    @FXML
    private WeatherForCityController weatherForCity2Controller;

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

        CountriesListService countriesListService = new CountriesListService();
        CitiesListService citiesListService = new CitiesListService();

        citiesListService.start();
        countriesListService.start();

        countriesListService.setOnSucceeded(e -> {
            initializeListOfCountries(countriesListService.getValue());
            addCountries(comboBoxCountries1);
            addCountries(comboBoxCountries2);
        });

        citiesListService.setOnSucceeded(e -> initializeListOfCities(citiesListService.getValue()));

        setDate();

        comboBoxCountries1.setOnAction(e -> addCities(comboBoxCities1, comboBoxCountries1));
        comboBoxCountries2.setOnAction(e -> addCities(comboBoxCities2, comboBoxCountries2));

        comboBoxCities1.setOnAction(e -> showWeather(comboBoxCities1, comboBoxCountries1));
        comboBoxCities2.setOnAction(e -> showWeather(comboBoxCities2, comboBoxCountries2));
    }

    private void initializeListOfCountries(List<Country> value) {
        countriesList = value;
    }

    private void initializeListOfCities(List<City> value) {
        citiesList = value;
        showComboBox();
    }

    private void showComboBox() {
        progressBar.setVisible(false);
        labelToProgressBar.setVisible(false);
        comboBoxCountries1.setVisible(true);
        comboBoxCountries2.setVisible(true);
    }

    private void addCountries(ComboBox<String> comboBoxCountries) {
        ObservableList<Country> countriesArray = FXCollections.observableList(countriesList);
        for(Country country : countriesArray) {
            comboBoxCountries.getItems().add(country.getName());
        }
        new AutoCompleteComboBoxListener<String>(comboBoxCountries);
    }

    private void setDate() {
        DateHandler dateHandler = new DateHandler();
        List<String> arrayOfFiveDays = dateHandler.createArrayOfFiveDays();
        date1.setText(arrayOfFiveDays.get(0));
        date2.setText(arrayOfFiveDays.get(1));
        date3.setText(arrayOfFiveDays.get(2));
        date4.setText(arrayOfFiveDays.get(3));
        date5.setText(arrayOfFiveDays.get(4));
    }

    private void addCities(ComboBox<String> comboBoxCities, ComboBox<String> comboBoxCountries) {
        resetGraphicAndTemperature(comboBoxCities);
        comboBoxCities.setValue("");
        comboBoxCities.getItems().clear();
        ObservableList<String> observableListCities;
        String selectedCountry = comboBoxCountries.getSelectionModel().selectedItemProperty().getValue();

        CitiesAndCountriesManager citiesAndCountries = new CitiesAndCountriesManager(countriesList, citiesList);

        if(!comboBoxCountries.getValue().equals("")) {
            observableListCities = (comboBoxCities.getId().equals("comboBoxCities1")) ? citiesAndCountries.getObservableList1(selectedCountry) : citiesAndCountries.getObservableList2(selectedCountry);
            if (!(observableListCities.get(0) == null)) {
                comboBoxCities.setVisible(true);
            }
            comboBoxCities.setItems(observableListCities);
        }
        new AutoCompleteComboBoxListener<String>(comboBoxCities);
    }

    private void showWeather(ComboBox<String> comboBoxCities, ComboBox<String> comboBoxCountries) {
        City city = null;
        CitiesAndCountriesManager citiesAndCountries = new CitiesAndCountriesManager(countriesList, citiesList);
        if(!comboBoxCities.getValue().equals("")) {

            showLoadingBar(comboBoxCities, true);
            resetGraphicAndTemperature(comboBoxCities);

            try {
                String selectedCityId = comboBoxCities.getId();
                String selectedCityName = comboBoxCities.getValue();
                String selectedCountryName = comboBoxCountries.getValue();

                city = citiesAndCountries.getCoordinate(selectedCityId, selectedCityName, selectedCountryName);
            } catch (IOException e) {
                App.showErrorMessage("Wystąpił problem z pobraniem danych pogodowych.");
            }

            assert city != null;
            WeatherService weatherService = new WeatherService(city.getLongitude(), city.getLatitude());

            weatherService.start();
            weatherService.setOnSucceeded(e -> {
                try {
                    weatherForecastManager = new WeatherForecastManager(weatherService.getValue());
                    setTemperature(weatherForecastManager.getWeatherObject(), comboBoxCities);
                    setConditions(weatherForecastManager.getWeatherObject(), comboBoxCities);
                    setDescription(weatherForecastManager.getWeatherObject(), comboBoxCities);
                    showLoadingBar(comboBoxCities, false);
                } catch (IOException ioException) {
                    App.showErrorMessage("Wystąpił problem z pobraniem danych pogodowych.");
                }
            });
        }
    }

    private void showLoadingBar(ComboBox<String> comboBoxCities, boolean showOrHide){
        if(comboBoxCities.getId().equals("comboBoxCities1")) {
            weatherForCity1Controller.loadingBar.setVisible(showOrHide);
        }
        else if(comboBoxCities.getId().equals("comboBoxCities2")) {
            weatherForCity2Controller.loadingBar.setVisible(showOrHide);
        }
    }

    private void setDescription(RootWeather weatherObject, ComboBox<String> comboBoxCities) {
        WeatherForecastFor5Days weatherForecastFor5Days = new WeatherForecastFor5Days();
        List<String> arrayOfDescription = weatherForecastFor5Days.getArrayOfDescription(weatherObject);
        if(comboBoxCities.getId().equals("comboBoxCities1")) {
            weatherForCity1Controller.setSingleDescription(arrayOfDescription);
        }
        else if(comboBoxCities.getId().equals("comboBoxCities2")) {
            weatherForCity2Controller.setSingleDescription(arrayOfDescription);
        }
    }

    private void setTemperature(RootWeather weatherObject, ComboBox<String> comboBoxCities) {
        WeatherForecastFor5Days weatherForecastFor5Days = new WeatherForecastFor5Days();
        List<String> arrayOfTemperature = weatherForecastFor5Days.getArrayOfTemperature(weatherObject);
        if(comboBoxCities.getId().equals("comboBoxCities1")) {
            weatherForCity1Controller.setSingleTemperature(arrayOfTemperature);
        }
        else if(comboBoxCities.getId().equals("comboBoxCities2")) {
            weatherForCity2Controller.setSingleTemperature(arrayOfTemperature);
        }
    }

    private void setConditions(RootWeather weatherObject, ComboBox<String> comboBoxCities) {
        GraphicService graphicService = new GraphicService(weatherObject);

        graphicService.start();
        graphicService.setOnSucceeded(e -> {

            List<Image> graphicList = graphicService.getValue();

            if(comboBoxCities.getId().equals("comboBoxCities1")) {
                weatherForCity1Controller.setSingleCondition(graphicList);
            }
            else if(comboBoxCities.getId().equals("comboBoxCities2")) {
                weatherForCity2Controller.setSingleCondition(graphicList);
            }
        });
    }

    private void resetGraphicAndTemperature(ComboBox<String> comboBoxCities) {
        if(comboBoxCities.getId().equals("comboBoxCities1")) {
            weatherForCity1Controller.resetSingleGraphicAndTemperature();
        }
        else if(comboBoxCities.getId().equals("comboBoxCities2")) {
            weatherForCity2Controller.resetSingleGraphicAndTemperature();
        }
    }
}
