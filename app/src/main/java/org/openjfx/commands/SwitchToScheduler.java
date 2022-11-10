package org.openjfx.commands;

import org.openjfx.SchedulerPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToScheduler implements SceneSwitch {
    private SchedulerPane newHome;

    public void execute(Stage stage) {
        newHome = new SchedulerPane(stage);
        Scene homeScene = new Scene(newHome,MainApp.WIDTH,MainApp.HEIGHT);
        stage.setTitle(SchedulerPane.title);
        stage.setScene(homeScene);
        stage.show();
    }
}