package org.openjfx;

import org.openjfx.Units.Activity;
import java.time.LocalTime;
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
import org.openjfx.commands.SwitchToHome;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 


// This is the builder for the Activity.java and employs a builder pattern
public class AddActivityPane extends VBox {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Add activity";

    public AddActivityPane(Stage stage) {
        // Set up screen elements
        this.setSpacing(10);
        Label welcomeLabel = new Label("Welcome to the 'Add activity' wizard.");
        TextField paFNameField = new TextField("Patient First Name");
        TextField paLNameField = new TextField("Patient Last Name");
        TextField acNameField = new TextField("Activity Name");
        TextField dtField = new TextField("Date(yyyy-mm-dd)");
        TextField stFieldHr = new TextField("Start hour");
        TextField stFieldMins = new TextField("Start min");
        TextField etFieldHr = new TextField("End hour");
        TextField etFieldMins = new TextField("End min");
        Label pAddedLabel = new Label(" ");
        Button addActivity = new Button("Schedule activity");
        Button exitButton = new Button("Exit without saving");
        this.getChildren().addAll(welcomeLabel,paFNameField,paLNameField,acNameField,dtField,pAddedLabel,stFieldHr,stFieldMins,etFieldHr,etFieldMins,addActivity,exitButton);
        
        // Action handler make thing happen when button click

        addActivity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(new FileReader("./src/main/resources/activity.json"));
                    JSONArray pList = (JSONArray)obj;
                    
                    JSONObject jo = new JSONObject();
                    jo.put("paFName", paFNameField.getText());
                    jo.put("paLName", paLNameField.getText()); 
                    jo.put("acName", acNameField.getText()); 
                    jo.put("dt", dtField.getText());
                    jo.put("sthr", stFieldHr.getText());
                    jo.put("stmin", stFieldMins.getText());
                    jo.put("ethr", stFieldHr.getText());
                    jo.put("etmin", etFieldMins.getText());
                    pList.add(jo);
                    
                    // writing JSON to file:"JSONExample.json" in cwd 
                    FileWriter pw = new FileWriter("./src/main/resources/activity.json"); 
                    pw.write(pList.toJSONString()); 
                    pw.flush(); 
                    pw.close(); 
                    pAddedLabel.setText("Activity added!");

                    int startHour = Integer.parseInt(stFieldHr.getText());
                    int startMins = Integer.parseInt(stFieldMins.getText());

                    int endHour = Integer.parseInt(etFieldHr.getText());
                    int endMins = Integer.parseInt(etFieldMins.getText());
                
                    //I think this needs to be able to append to SchedulerPane.java
                    Activity newAc = new Activity.Builder(acNameField.getText()).start(LocalTime.of(startHour, startMins)).end(LocalTime.of(endHour, endMins)).build();

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
