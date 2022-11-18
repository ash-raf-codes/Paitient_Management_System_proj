package org.openjfx.commands;

import org.openjfx.AddPatientPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToAddPatient implements SceneSwitch {
    private AddPatientPane newPane;

    public void execute(Stage stage) {
        newPane = new AddPatientPane(stage);
        Scene newScene = new Scene(newPane,MainApp.WIDTH,MainApp.HEIGHT);
        newScene.getStylesheets().add("./org/openjfx/styles.css");
        stage.setTitle(AddPatientPane.title);
        stage.setScene(newScene);
        stage.show();
    }
}