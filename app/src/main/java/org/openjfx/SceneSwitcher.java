package org.openjfx;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// The intent here is to reduce code duplication by making a class with methods to switch from pane x to y
public class SceneSwitcher {

    public SceneSwitcher(){}

    public static void sceneSwitch(Stage stage, HomePane home) {
        Scene homeScene = new Scene(home,MainApp.WIDTH,MainApp.HEIGHT);
        //viewPatientsScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle(home.title);
        stage.setScene(homeScene);
        stage.show();
    }

    public static void sceneSwitch(Stage stage, AddPatientPane apPane) {
        Scene addPatientScene = new Scene(apPane,MainApp.WIDTH,MainApp.HEIGHT);
        //addPatientScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle(apPane.title);
        stage.setScene(addPatientScene);
        stage.show();
    }

    public static void sceneSwitch(Stage stage, ViewPatientsPane vpPane) {
        Scene viewPatientsScene = new Scene(vpPane,MainApp.WIDTH,MainApp.HEIGHT);
        //viewPatientsScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle(vpPane.title);
        stage.setScene(viewPatientsScene);
        stage.show();
    }
    
    public static void sceneSwitch(Stage stage, Pane pane) {
        Scene newScene = new Scene(pane,MainApp.WIDTH,MainApp.HEIGHT);
        //viewPatientsScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        //stage.setTitle(pane.title);
        stage.setScene(newScene);
        stage.show();
    }
}
