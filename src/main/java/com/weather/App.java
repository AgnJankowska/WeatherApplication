package com.weather;

import com.weather.view.ViewFactory;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showAppWindow();
    }

    public static void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wystąpił błąd");
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}