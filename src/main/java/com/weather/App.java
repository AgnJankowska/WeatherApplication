package com.weather;

import com.weather.controller.AppWindowController;
import com.weather.view.ViewFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showAppWindow();
    }

    public static void main(String[] args) {
        launch();
    }

}