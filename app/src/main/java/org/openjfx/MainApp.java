package org.openjfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.openjfx.commands.*;


public class MainApp extends Application {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    @Override
    public void start(Stage stage) throws Exception {
        // Set up business objects here!


        // Set up home scene
        SwitchToHome home = new SwitchToHome();
            home.execute(stage);

    }

    public static void main(String[] args) {
        launch(args);
    }

}