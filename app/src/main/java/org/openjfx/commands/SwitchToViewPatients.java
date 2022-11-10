package org.openjfx.commands;

import org.openjfx.ViewPatientsPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToViewPatients implements SceneSwitch {
    private ViewPatientsPane newHome;

    public void execute(Stage stage) {
        newHome = new ViewPatientsPane(stage);
        Scene homeScene = new Scene(newHome,MainApp.WIDTH,MainApp.HEIGHT);
        stage.setTitle(ViewPatientsPane.title);
        stage.setScene(homeScene);
        stage.show();
    }
}