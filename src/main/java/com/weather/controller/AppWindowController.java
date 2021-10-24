package com.weather.controller;

import com.weather.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AppWindowController {

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

}
