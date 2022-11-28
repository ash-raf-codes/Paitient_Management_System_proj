package org.openjfx.commands;

import org.openjfx.SchedulerPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToScheduler implements SceneSwitch {
    private SchedulerPane newPane;

    public void execute(Stage stage) {
        newPane = new SchedulerPane(stage);
        Scene newScene = new Scene(newPane,MainApp.WIDTH,MainApp.HEIGHT);
        newScene.getStylesheets().add("./org/openjfx/styles.css");
        stage.setTitle(SchedulerPane.title);
        stage.setScene(newScene);
        stage.show();
    }
}