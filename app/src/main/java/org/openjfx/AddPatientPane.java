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
        TextField idField = new TextField("Medical ID");
        Label pAddedLabel = new Label(" ");
        this.add(pAddedLabel,0,4);
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
