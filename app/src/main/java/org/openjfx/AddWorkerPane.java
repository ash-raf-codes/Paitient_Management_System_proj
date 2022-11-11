package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import org.openjfx.Units.Employee;
import org.openjfx.Units.CareWorkerAdapter;
import java.io.*;
import java.util.Random;

import org.json.simple.parser.*;
import org.openjfx.commands.SwitchToHome;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 

public class AddWorkerPane extends VBox {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Add Worker";

    public AddWorkerPane(Stage stage) {
        // Set up screen elements
        this.setSpacing(10);
        Label welcomeLabel = new Label("Welcome to the 'add care worker' wizard.");
        TextField pfNameField = new TextField("First Name");
        TextField plNameField = new TextField("Last Name");
        TextField dobField = new TextField("Date of Birth (yyyy-mm-dd)");
        Label pAddedLabel = new Label(" ");
        Button addWorkerButton = new Button("Add Care Worker");
        Button exitButton = new Button("Exit");
        this.getChildren().addAll(welcomeLabel,pfNameField,plNameField,dobField,pAddedLabel,addWorkerButton,exitButton);
        
        // Action handler make thing happen when button click

        addWorkerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(new FileReader("./src/main/resources/careworkers.json"));
                    JSONArray pList = (JSONArray)obj;
                    
                    JSONObject jo = new JSONObject();
                    jo.put("firstName", pfNameField.getText()); 
                    jo.put("lastName", plNameField.getText()); 
                    jo.put("dob", dobField.getText());
                    pList.add(jo);
                    
                    FileWriter pw = new FileWriter("./src/main/resources/careworkers.json"); 
                    pw.write(pList.toJSONString()); 
                    pw.flush(); 
                    pw.close(); 
                    pAddedLabel.setText("Worker added!");

                    // Building the Employee object. Requires an adapter to add it to careworkers.json
                    Employee newEmp = new Employee(pfNameField.getText(),plNameField.getText(), idGenerator(), dobField.getText());
                    CareWorkerAdapter.storeWorker(newEmp);
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
    // Employee ID generator. Source: https://www.baeldung.com/java-random-string
    public String idGenerator() {
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
    }
    
}
