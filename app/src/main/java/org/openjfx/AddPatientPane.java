package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

import org.openjfx.commands.SwitchToHome;

import java.util.LinkedList;
import org.openjfx.Units.*;
import java.io.*;


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
        TextField idField = new TextField("Medical ID");
        Label pAddedLabel = new Label(" ");
        Button addPatientButton = new Button("Add Patient");
        Button exitButton = new Button("Exit without saving");
        
        ComboBox comboBox = new ComboBox();

        try {
            LinkedList<Employee> plist = CareWorkerAdapter.retrieve();

            var iterator = plist.iterator();
            while (iterator.hasNext()) {
                Employee cur = iterator.next();
                comboBox.getItems().add(cur.getId() + ": " + cur.getLastName());
            }
        } catch (Exception e) { e.printStackTrace(); }

        this.getChildren().addAll(welcomeLabel,pfNameField,plNameField,dobField,idField,comboBox,pAddedLabel,addPatientButton,exitButton);
        
        // Action handler make thing happen when button click

        addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Patient newpatient = new Patient(pfNameField.getText(), plNameField.getText(),idField.getText(), dobField.getText());
                    newpatient.store();
                    String[] empID = ((String)comboBox.getValue()).split(":");
                    CareWorkerAdapter.addPatientToEmployee(empID[0], newpatient.getId());
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
