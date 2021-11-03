package com.weather.controller;

import com.weather.model.*;
import com.weather.model.auxiliaryClasses.AutoCompleteComboBoxListener;
import com.weather.model.weatherCondition.DescriptionOfCondition;
import com.weather.view.ViewFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AppWindowController implements Initializable {

    protected ViewFactory viewFactory;
    private String fxmlName;
    private JSONReaderLocation jsonReader;
    private ObservableList<String> countries;
    private CitiesAndCountries citiesAndCountries;
    private ObservableList<String> observableListCities;

    public AppWindowController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
        this.jsonReader = new JSONReaderLocation();
        this.countries = jsonReader.getCountriesArray();
        this.citiesAndCountries = new CitiesAndCountries();
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

    @FXML
    private ImageView graphic11;

    @FXML
    private ImageView graphic12;

    @FXML
    private ImageView graphic13;

    @FXML
    private ImageView graphic14;

    @FXML
    private ImageView graphic15;

    @FXML
    private ImageView graphic21;

    @FXML
    private ImageView graphic22;

    @FXML
    private ImageView graphic23;

    @FXML
    private ImageView graphic24;

    @FXML
    private ImageView graphic25;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCountries(comboBoxCountries1);
        addCountries(comboBoxCountries2);
        setDate();

        try {
            setInitialGraphic();
        } catch (IOException e) {
            e.printStackTrace();
        }

        comboBoxCountries1.setOnAction(e -> addCities(comboBoxCities1, comboBoxCountries1));
        comboBoxCountries2.setOnAction(e -> addCities(comboBoxCities2, comboBoxCountries2));
        comboBoxCities1.setOnAction(e -> showWeather(comboBoxCities1));
        comboBoxCities2.setOnAction(e -> showWeather(comboBoxCities2));
    }

    private void setInitialGraphic() throws IOException {
        WeatherForecastManager weatherForecastManager = new WeatherForecastManager();
        graphic11.setImage(weatherForecastManager.getInitialGraphic());
        graphic12.setImage(weatherForecastManager.getInitialGraphic());
        graphic13.setImage(weatherForecastManager.getInitialGraphic());
        graphic14.setImage(weatherForecastManager.getInitialGraphic());
        graphic15.setImage(weatherForecastManager.getInitialGraphic());
        graphic21.setImage(weatherForecastManager.getInitialGraphic());
        graphic22.setImage(weatherForecastManager.getInitialGraphic());
        graphic23.setImage(weatherForecastManager.getInitialGraphic());
        graphic24.setImage(weatherForecastManager.getInitialGraphic());
        graphic25.setImage(weatherForecastManager.getInitialGraphic());
    }

    private void addCountries(ComboBox<String> comboBoxCountries) {
        comboBoxCountries.setItems(countries);
        new AutoCompleteComboBoxListener<>(comboBoxCountries);
    }

    private void addCities(ComboBox<String> comboBoxCities, ComboBox<String> comboBoxCountries) {
        comboBoxCities.setValue("");
        comboBoxCities.getItems().clear();
        comboBoxCities.setVisible(true);

        String selectedCountry = comboBoxCountries.getSelectionModel().selectedItemProperty().getValue();
        observableListCities = (comboBoxCities.getId().equals("comboBoxCities1")) ? citiesAndCountries.getObservableList1(selectedCountry) : citiesAndCountries.getObservableList2(selectedCountry);

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
        if(!comboBoxCities.getValue().equals("")) {
            try {
                String selectedCityId = comboBoxCities.getId();
                String selectedCityName = comboBoxCities.getValue();
                city = citiesAndCountries.getCoordinate(selectedCityId, selectedCityName);
                WeatherForecastManager weatherForecastManager = new WeatherForecastManager(city.getLongitude(), city.getLatitude());

                setTemperature(weatherForecastManager, comboBoxCities);
                setConditions(weatherForecastManager, comboBoxCities);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setConditions(WeatherForecastManager weatherForecastManager, ComboBox<String> comboBoxCities) {
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

    private void setTemperature(WeatherForecastManager weatherForecastManager, ComboBox<String> comboBoxCities) {

        if(comboBoxCities.getId().equals("comboBoxCities1")) {
            graphic11.setImage(weatherForecastManager.getGraphic(0));
            graphic12.setImage(weatherForecastManager.getGraphic(1));
            graphic13.setImage(weatherForecastManager.getGraphic(2));
            graphic14.setImage(weatherForecastManager.getGraphic(3));
            graphic15.setImage(weatherForecastManager.getGraphic(4));
        }
        else if(comboBoxCities.getId().equals("comboBoxCities2")) {
            graphic21.setImage(weatherForecastManager.getGraphic(0));
            graphic22.setImage(weatherForecastManager.getGraphic(1));
            graphic23.setImage(weatherForecastManager.getGraphic(2));
            graphic24.setImage(weatherForecastManager.getGraphic(3));
            graphic25.setImage(weatherForecastManager.getGraphic(4));
        }
    }

}
