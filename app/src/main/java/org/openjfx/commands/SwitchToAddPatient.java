package org.openjfx.commands;

import org.openjfx.AddPatientPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToAddPatient implements SceneSwitch {
    private AddPatientPane newHome;

    public void execute(Stage stage) {
        newHome = new AddPatientPane(stage);
        Scene homeScene = new Scene(newHome,MainApp.WIDTH,MainApp.HEIGHT);
        stage.setTitle(AddPatientPane.title);
        stage.setScene(homeScene);
        stage.show();
    }
}