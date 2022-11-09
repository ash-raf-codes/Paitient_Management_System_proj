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

public class AddActivityPane extends VBox {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Add activity";

    public AddActivityPane(Stage stage) {
        // Set up screen elements
        this.setSpacing(10);
        Label welcomeLabel = new Label("Welcome to the 'Add activity' wizard.");
        TextField paNameField = new TextField("Patient Name");
        TextField acNameField = new TextField("Activity Name");
        TextField dtField = new TextField("Date(yyyy-mm-dd)");
        TextField stField = new TextField("Time (hr:min)");
        TextField etField = new TextField("Time (hr:min)");
        Label pAddedLabel = new Label(" ");
        Button addActivity = new Button("Schedule activity");
        Button exitButton = new Button("Exit without saving");
        this.getChildren().addAll(welcomeLabel,paNameField,acNameField,dtField,pAddedLabel, stField, etField, addActivity,exitButton);
        
        // Action handler make thing happen when button click

        addActivity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(new FileReader("./src/main/resources/activity.json"));
                    JSONArray pList = (JSONArray)obj;
                    
                    JSONObject jo = new JSONObject();
                    jo.put("paName", paNameField.getText()); 
                    jo.put("acName", acNameField.getText()); 
                    jo.put("dt", dtField.getText());
                    jo.put("st", stField.getText());
                    jo.put("et", etField.getText());
                    pList.add(jo);
                    
                    // writing JSON to file:"JSONExample.json" in cwd 
                    FileWriter pw = new FileWriter("./src/main/resources/activity.json"); 
                    pw.write(pList.toJSONString()); 
                    pw.flush(); 
                    pw.close(); 
                    pAddedLabel.setText("Activity added!");

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
