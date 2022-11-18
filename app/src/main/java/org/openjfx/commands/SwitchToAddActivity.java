package org.openjfx.commands;

import org.openjfx.AddActivityPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToAddActivity implements SceneSwitch {
    private AddActivityPane newPane;

    public void execute(Stage stage) {
        newPane = new AddActivityPane(stage);
        Scene newScene = new Scene(newPane,MainApp.WIDTH,MainApp.HEIGHT);
        newScene.getStylesheets().add("./org/openjfx/styles.css");
        stage.setTitle(AddActivityPane.title);
        stage.setScene(newScene);
        stage.show();
    }
}