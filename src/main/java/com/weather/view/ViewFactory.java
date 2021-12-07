package com.weather.view;

import com.weather.controller.AppWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class ViewFactory {

    public void showAppWindow() {
        AppWindowController controller = new AppWindowController(this,"AppWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(AppWindowController controller) {
        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent;
        try{
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/style.css")).toExternalForm());
        Stage stage = new Stage();

        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);

        stage.show();
    }
}
