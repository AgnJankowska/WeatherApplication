module com.weather {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.weather to javafx.fxml;
    exports com.weather;

    opens com.weather.controller to javafx.fxml;
    exports com.weather.controller;

}