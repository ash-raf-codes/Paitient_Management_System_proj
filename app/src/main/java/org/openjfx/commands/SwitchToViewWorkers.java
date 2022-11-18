package org.openjfx.commands;

import org.openjfx.ViewWorkersPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToViewWorkers implements SceneSwitch {
    private ViewWorkersPane newPane;

    public void execute(Stage stage) {
        newPane = new ViewWorkersPane(stage);
        Scene newScene = new Scene(newPane,MainApp.WIDTH,MainApp.HEIGHT);
        newScene.getStylesheets().add("./org/openjfx/styles.css");
        stage.setTitle(ViewWorkersPane.title);
        stage.setScene(newScene);
        stage.show();
    }
}