package com.weather;

import com.weather.view.ViewFactory;
import javafx.application.Application;
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