package com.weather.view;

import com.weather.controller.AppWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


}
