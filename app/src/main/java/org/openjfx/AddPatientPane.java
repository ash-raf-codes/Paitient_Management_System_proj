package org.openjfx;

import javafx.stage.Stage;
//import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 

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
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(new FileReader("patients.json"));
                    JSONArray pList = (JSONArray)obj;
                    
                    JSONObject jo = new JSONObject();
                    jo.put("firstName", pfNameField.getText()); 
                    jo.put("lastName", plNameField.getText()); 
                    jo.put("dob", dobField.getText());
                    pList.add(jo);
                    
                    // writing JSON to file:"JSONExample.json" in cwd 
                    FileWriter pw = new FileWriter("patients.json"); 
                    pw.write(pList.toJSONString()); 
                    pw.flush(); 
                    pw.close(); 
                    pAddedLabel.setText("Patient added!");

                } catch (Exception e) { e.printStackTrace(); }
            }
        });  // Note this weird }); for action handlers

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SceneSwitcher.sceneSwitch(stage, new HomePane(stage));
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers
    }
    
}
