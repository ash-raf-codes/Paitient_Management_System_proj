package org.openjfx.commands;

import org.openjfx.HomePane;
import org.openjfx.MainApp;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchToHome implements SceneSwitch {
    private HomePane newHome;

    public void execute(Stage stage) {
        newHome = new HomePane(stage);
        Scene homeScene = new Scene(newHome,MainApp.WIDTH,MainApp.HEIGHT);
        stage.setTitle(HomePane.title);
        stage.setScene(homeScene);
        stage.show();
    }
}
