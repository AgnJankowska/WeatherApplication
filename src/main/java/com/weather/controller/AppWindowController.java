package com.weather.controller;

import com.weather.model.DateHandler;
import com.weather.model.JSONReader;
import com.weather.model.AutoCompleteComboBoxListener;
import com.weather.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    void buttonAction1() {

    }

    @FXML
    void buttonAction2() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCountries(comboBoxCountries1);
        addCountries(comboBoxCountries2);
        comboBoxCountries1.setOnAction(e -> addCities(comboBoxCities1, comboBoxCountries1));
        comboBoxCountries2.setOnAction(e -> addCities(comboBoxCities2, comboBoxCountries2));
        setCurrentDate();
    }

    private void addCountries(ComboBox<String> comboBoxCountries) {
        ObservableList<String> observableListCountries = FXCollections.observableList(countries);
        comboBoxCountries.setItems(observableListCountries);

        //autocomplete elements of the list after typing
        new AutoCompleteComboBoxListener<>(comboBoxCountries);
    }

    private void addCities(ComboBox<String> comboBoxCities, ComboBox<String> comboBoxCountries) {
        comboBoxCities.setVisible(true);
        comboBoxCities.getItems().clear();

        String selectedCountry = comboBoxCountries.getSelectionModel().selectedItemProperty().getValue();
        cities = jsonReader.getCitiesOfSelectedCountry(selectedCountry);
        Collections.sort(cities);

        ObservableList<String> observableListCities = FXCollections.observableList(cities);
        comboBoxCities.setItems(observableListCities);

        //autocomplete elements of the list after typing
        new AutoCompleteComboBoxListener<>(comboBoxCities);
    }

    private void setCurrentDate() {
        DateHandler dateHandler = new DateHandler();

        date1.setText(dateHandler.getArrayOfFiveDays().get(0));
        date2.setText(dateHandler.getArrayOfFiveDays().get(1));
        date3.setText(dateHandler.getArrayOfFiveDays().get(2));
        date4.setText(dateHandler.getArrayOfFiveDays().get(3));
        date5.setText(dateHandler.getArrayOfFiveDays().get(4));
    }
}
