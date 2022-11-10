package org.openjfx.commands;

import org.openjfx.AddWorkerPane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToAddWorker implements SceneSwitch {
    private AddWorkerPane newHome;

    public void execute(Stage stage) {
        newHome = new AddWorkerPane(stage);
        Scene homeScene = new Scene(newHome,MainApp.WIDTH,MainApp.HEIGHT);
        stage.setTitle(AddWorkerPane.title);
        stage.setScene(homeScene);
        stage.show();
    }
}