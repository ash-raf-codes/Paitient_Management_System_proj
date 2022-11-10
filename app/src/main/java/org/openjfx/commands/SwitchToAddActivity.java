package org.openjfx.commands;

import org.openjfx.AddActivityPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToAddActivity implements SceneSwitch {
    private AddActivityPane newHome;

    public void execute(Stage stage) {
        newHome = new AddActivityPane(stage);
        Scene homeScene = new Scene(newHome,MainApp.WIDTH,MainApp.HEIGHT);
        stage.setTitle(AddActivityPane.title);
        stage.setScene(homeScene);
        stage.show();
    }
}