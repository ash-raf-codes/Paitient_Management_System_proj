package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    @Override
    public void start(Stage stage) throws Exception {
        // Set up business objects here!


        // Set up home scene
        HomePane homePane = new HomePane(stage);
        Scene homeScene = new Scene(homePane,WIDTH,HEIGHT);
        homeScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
       
        // Launches stage (window)
        stage.setTitle("Rementi: Patient and Staff Scheduler Home Screen");
        stage.setScene(homeScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}