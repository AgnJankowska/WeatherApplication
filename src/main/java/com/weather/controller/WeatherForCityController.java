package com.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;

public class WeatherForCityController {

    @FXML
    protected Label temp11;

    @FXML
    protected Label description11;

    @FXML
    protected ImageView graphic11;

    @FXML
    protected ImageView graphic12;

    @FXML
    protected ImageView graphic13;

    @FXML
    protected ImageView graphic14;

    @FXML
    protected ImageView graphic15;

    @FXML
    protected Label temp12;

    @FXML
    protected Label description12;

    @FXML
    protected Label description13;

    @FXML
    protected Label temp13;

    @FXML
    protected Label description14;

    @FXML
    protected Label temp14;

    @FXML
    protected Label description15;

    @FXML
    protected Label temp15;

    @FXML
    protected ProgressIndicator loadingBar;

    public void setSingleDescription(List<String> arrayOfDescription) {
        description11.setText(arrayOfDescription.get(0));
        description12.setText(arrayOfDescription.get(1));
        description13.setText(arrayOfDescription.get(2));
        description14.setText(arrayOfDescription.get(3));
        description15.setText(arrayOfDescription.get(4));
    }

    public void setSingleTemperature(List<String> arrayOfTemperature) {
        temp11.setText(arrayOfTemperature.get(0) + '\u00B0' + "C");
        temp12.setText(arrayOfTemperature.get(1) + '\u00B0' + "C");
        temp13.setText(arrayOfTemperature.get(2) + '\u00B0' + "C");
        temp14.setText(arrayOfTemperature.get(3) + '\u00B0' + "C");
        temp15.setText(arrayOfTemperature.get(4) + '\u00B0' + "C");
    }

    public void setSingleCondition(List<Image> graphicList) {
        graphic11.setImage(graphicList.get(0));
        graphic12.setImage(graphicList.get(1));
        graphic13.setImage(graphicList.get(2));
        graphic14.setImage(graphicList.get(3));
        graphic15.setImage(graphicList.get(4));
    }

    public void resetSingleGraphicAndTemperature() {
        graphic11.setImage(null);
        graphic12.setImage(null);
        graphic13.setImage(null);
        graphic14.setImage(null);
        graphic15.setImage(null);
        temp11.setText("");
        temp12.setText("");
        temp13.setText("");
        temp14.setText("");
        temp15.setText("");
        description11.setText("");
        description12.setText("");
        description13.setText("");
        description14.setText("");
        description15.setText("");
    }
}
