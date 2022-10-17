package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static final int WIDTH = 400;
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

        /* This code block is a brute force, ugly way to swap scenes
        //Scene 1
        VBox layout1 = new VBox(20);     
        Label label1= new Label("Rementi: Patient and Staff Scheduler");
        Button button1= new Button("Add Patient"); 
        layout1.getChildren().addAll(label1, button1);
        Scene scene1 = new Scene(layout1, 300, 250);
        //Scene 2
        VBox layout2= new VBox(20);
        Label label2= new Label("This is the 'add patient' screen");
        Button button2= new Button("Go back to home");
        layout2.getChildren().addAll(label2, button2);
        Scene scene2 = new Scene(layout2,300,250);
        //Actions
        button1.setOnAction(e -> stage.setScene(scene2));          
        button2.setOnAction(e -> stage.setScene(scene1));
        
                
        stage.setScene(scene1);
        stage.show();
        */
    }

    public static void main(String[] args) {
        launch(args);
    }

}