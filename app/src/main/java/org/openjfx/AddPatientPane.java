package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
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

        Label idLabel = new Label("Medical ID");
        this.add(idLabel,0,4);
        TextField idField = new TextField("Medical ID");
        this.add(idField,1,4);

        Label cwLabel = new Label("Patient's care worker");
        this.add(cwLabel,0,5);
        ComboBox comboBox = new ComboBox();
        try {
            LinkedList<Employee> plist = CareWorkerAdapter.retrieve();

            var iterator = plist.iterator();
            while (iterator.hasNext()) {
                Employee cur = iterator.next();
                comboBox.getItems().add(cur.getId() + ": " + cur.getLastName());
            }
        } catch (Exception e) { e.printStackTrace(); }
        this.add(comboBox,1,5);

        Label pAddedLabel = new Label(" ");
        this.add(pAddedLabel,0,6);
        Button addPatientButton = new Button("Add Patient");
        this.add(addPatientButton,0,7);
        Button exitButton = new Button("Exit");
        this.add(exitButton,0,8);
        //this.getChildren().addAll(welcomeLabel,pfNameField,plNameField,dobField,idField,comboBox,pAddedLabel,addPatientButton,exitButton);
        
        // Action handler make thing happen when button click

        addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(!InputChecker.checkDate(dobField.getText())){
                        pAddedLabel.setText("invalid DOB");

                    } else if(!InputChecker.checkName(pfNameField.getText())){
                        pAddedLabel.setText("invalid first name");

                    } else if(!InputChecker.checkName(plNameField.getText())){
                        pAddedLabel.setText("invalid last name");

                    } else if(!InputChecker.checkID(idField.getText())){
                        pAddedLabel.setText("invalid ID");

                    } 
                    Patient newpatient = new Patient(pfNameField.getText(), plNameField.getText(),idField.getText(), dobField.getText());
                    String[] empID = ((String)comboBox.getValue()).split(":");

                    if(empID[0].length() == 0){
                        pAddedLabel.setText("Employee not chosen");
                    }
                    else if(InputChecker.checkPatient(idField.getText())){ // checks if a patient exists
                        newpatient.store();
                        CareWorkerAdapter.addPatientToEmployee(empID[0], newpatient.getId());
                        pAddedLabel.setText("Patient added!");
                    } else {
                        pAddedLabel.setText("Patient already in database.");
                    }
                    //pAddedLabel.setText("Patient added!");
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
