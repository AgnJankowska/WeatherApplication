package com.weather.controller;

import com.weather.model.AutoCompleteComboBoxListener;
import com.weather.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AppWindowController implements Initializable {

    protected ViewFactory viewFactory;
    private String fxmlName;

    public AppWindowController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }

    @FXML
    private ComboBox<String> comboBox;

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
        comboBox.getItems().add("Option1");
        comboBox.getItems().add("Aga");
        comboBox.getItems().add("Anna");

        comboBox.setEditable(true);
        new AutoCompleteComboBoxListener<>(comboBox);
        comboBox.setOnAction(e -> System.out.println("cos"));

    }



}
