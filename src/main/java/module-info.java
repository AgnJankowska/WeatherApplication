module com.weather {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires json.simple;

    opens com.weather to javafx.fxml;
    exports com.weather;

    opens com.weather.controller to javafx.fxml;
    exports com.weather.controller;

    opens com.weather.view to javafx.fxml;
    exports com.weather.view;

    opens com.weather.model to javafx.fxml;
    exports com.weather.model;

}