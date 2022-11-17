package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.openjfx.commands.SwitchToHome;

import org.openjfx.Units.*;

public class AddPatientPane extends VBox {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Add Patient";

    public AddPatientPane(Stage stage) {
        // Set up screen elements
        this.setSpacing(10);
        Label welcomeLabel = new Label("Welcome to the 'add patient' wizard.");
        TextField pfNameField = new TextField("First Name");
        TextField plNameField = new TextField("Last Name");
        TextField dobField = new TextField("Date of Birth (yyyy-mm-dd)");
        Label pAddedLabel = new Label(" ");
        Button addPatientButton = new Button("Add Patient");
        Button exitButton = new Button("Exit without saving");
        this.getChildren().addAll(welcomeLabel,pfNameField,plNameField,dobField,pAddedLabel,addPatientButton,exitButton);
        
        // Action handler make thing happen when button click

        addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Patient newpatient = new Patient(pfNameField.getText(), plNameField.getText(),"123456", dobField.getText(),"diagnosis");
                    newpatient.store();
                    pAddedLabel.setText("Patient added!");

                } catch (Exception e) { e.printStackTrace(); }
            }
        });  // Note this weird }); for action handlers

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SwitchToHome home = new SwitchToHome();
                    home.execute(stage);
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers
    }
    
}
