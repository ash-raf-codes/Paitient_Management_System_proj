package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import org.openjfx.Units.Employee;
import org.openjfx.Units.Person;
import org.openjfx.Units.CareWorkerAdapter;
import java.io.*;
import java.util.Random;

import org.openjfx.commands.SwitchToHome;


public class AddWorkerPane extends GridPane {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Add Worker";

    public AddWorkerPane(Stage stage) {
        // Set up screen elements
        this.setHgap(10);
        this.setVgap(10);
        
        Label welcomeLabel = new Label("Add Care Worker");
        welcomeLabel.setId("welcomeLabel");
        this.add(welcomeLabel,0,0,3,1);

        Label wfnLabel = new Label("First Name");
        this.add(wfnLabel,0,1);
        TextField wfNameField = new TextField("First Name");
        this.add(wfNameField,1,1);

        Label wlnLabel = new Label("Last Name");
        this.add(wlnLabel,0,2);
        TextField wlNameField = new TextField("Last Name");
        this.add(wlNameField,1,2);

        Label dobLabel = new Label("Date of Birth");
        this.add(dobLabel,0,3);
        TextField dobField = new TextField("Date of Birth (yyyy-mm-dd)");
        TextField employeeIDField = new TextField("Employee ID");
        Label pAddedLabel = new Label(" ");
        Button addWorkerButton = new Button("Add Care Worker");
        Button exitButton = new Button("Exit");
        this.getChildren().addAll(welcomeLabel,pfNameField,plNameField,dobField,employeeIDField,pAddedLabel,addWorkerButton,exitButton);
        
        // Action handler make thing happen when button click

        addWorkerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Building the Employee object. Requires an adapter to add it to careworkers.json
                    Person newEmp = new Employee.Builder(employeeIDField.getText()).fn(pfNameField.getText()).ln(plNameField.getText()).dob(dobField.getText()).build();
                    newEmp.store();
                    pAddedLabel.setText("Employee added!");


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
    //NOT BEING USED, CAN WE REMOVE?
    // Employee ID generator. Source: https://www.baeldung.com/java-random-string
    /*public String idGenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    
        return generatedString;
    }*/
    
}
