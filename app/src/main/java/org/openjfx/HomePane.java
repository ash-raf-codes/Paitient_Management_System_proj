package org.openjfx;

import javafx.stage.Stage;
//import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomePane extends VBox {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Home";

    public HomePane(Stage stage) {
        // Set up screen elements
        this.setSpacing(20);
        Label welcomeLabel = new Label("Welcome to Rementi care home management system!");
        Button addPatientButton = new Button("Add Patient");
        Button viewPatientsButton = new Button("View Patients");
        this.getChildren().addAll(welcomeLabel,addPatientButton,viewPatientsButton);

        // Action handler make thing happen when button click
        addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SceneSwitcher.sceneSwitch(stage, new AddPatientPane(stage));
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers

        viewPatientsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SceneSwitcher.sceneSwitch(stage, new ViewPatientsPane(stage));
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers
    }
    
}
