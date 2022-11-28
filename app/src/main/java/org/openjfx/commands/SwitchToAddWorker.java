package org.openjfx.commands;

import org.openjfx.AddWorkerPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToAddWorker implements SceneSwitch {
    private AddWorkerPane newPane;

    public void execute(Stage stage) {
        newPane = new AddWorkerPane(stage);
        Scene newScene = new Scene(newPane,MainApp.WIDTH,MainApp.HEIGHT);
        newScene.getStylesheets().add("./org/openjfx/styles.css");
        stage.setTitle(AddWorkerPane.title);
        stage.setScene(newScene);
        stage.show();
    }
}