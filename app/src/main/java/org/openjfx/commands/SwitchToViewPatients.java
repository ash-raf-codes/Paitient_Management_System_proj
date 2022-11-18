package org.openjfx.commands;

import org.openjfx.ViewPatientsPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToViewPatients implements SceneSwitch {
    private ViewPatientsPane newPane;

    public void execute(Stage stage) {
        newPane = new ViewPatientsPane(stage);
        Scene newScene = new Scene(newPane,MainApp.WIDTH,MainApp.HEIGHT);
        newScene.getStylesheets().add("./org/openjfx/styles.css");
        stage.setTitle(ViewPatientsPane.title);
        stage.setScene(newScene);
        stage.show();
    }
}