package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.openjfx.commands.SwitchToHome;

import org.openjfx.Units.*;

public class AddPatientPane extends GridPane {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Add Patient Wizard";

    public AddPatientPane(Stage stage) {
        // Set up screen elements
        this.setHgap(10);
        this.setVgap(10);

        Label welcomeLabel = new Label("Add Patient");
        welcomeLabel.setId("welcomeLabel");
        this.add(welcomeLabel,0,0,3,1);

        Label pfnLabel = new Label("First Name");
        this.add(pfnLabel,0,1);
        TextField pfNameField = new TextField("First Name");
        this.add(pfNameField,1,1);

        Label plnLabel = new Label("Last Name");
        this.add(plnLabel,0,2);
        TextField plNameField = new TextField("Last Name");
        this.add(plNameField,1,2);

        Label dobLabel = new Label("Date of Birth");
        this.add(dobLabel,0,3);
        TextField dobField = new TextField("Date of Birth (yyyy-mm-dd)");
        this.add(dobField,1,3);

        Label pAddedLabel = new Label(" ");
        this.add(pAddedLabel,0,4);
        Button addPatientButton = new Button("Add Patient");
        this.add(addPatientButton,0,5);
        Button exitButton = new Button("Exit to Home");
        this.add(exitButton,0,6);
        //this.getChildren().addAll(welcomeLabel,pfNameField,plNameField,dobField,pAddedLabel,addPatientButton,exitButton);
        
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
