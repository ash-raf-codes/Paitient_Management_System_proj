package org.openjfx.commands;

import org.openjfx.ViewWorkersPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToViewWorkers implements SceneSwitch {
    private ViewWorkersPane newHome;

    public void execute(Stage stage) {
        newHome = new ViewWorkersPane(stage);
        Scene homeScene = new Scene(newHome,MainApp.WIDTH,MainApp.HEIGHT);
        stage.setTitle(ViewWorkersPane.title);
        stage.setScene(homeScene);
        stage.show();
    }
}