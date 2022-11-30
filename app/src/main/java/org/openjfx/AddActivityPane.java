package org.openjfx;

import org.openjfx.Units.Activity;
import org.openjfx.Units.PatientAdapter;

import java.time.LocalTime;
import javafx.stage.Stage;
//import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

import java.io.*;
import org.json.simple.parser.*;
import org.openjfx.commands.SwitchToHome;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 

import java.util.LinkedList;
import org.openjfx.Units.*;


// This is the builder for the Activity.java and employs a builder pattern
public class AddActivityPane extends VBox {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Add activity";

    public AddActivityPane(Stage stage) {
        // Set up screen elements
        this.setSpacing(10);
        Label welcomeLabel = new Label("Welcome to the 'Add activity' wizard.");
        TextField acNameField = new TextField("Activity Name");
        TextField stFieldHr = new TextField("Start hour");
        TextField stFieldMins = new TextField("Start min");
        TextField etFieldHr = new TextField("End hour");
        TextField etFieldMins = new TextField("End min");
        Label pAddedLabel = new Label(" ");
        Button addActivity = new Button("Schedule activity");
        Button exitButton = new Button("Exit");
        ComboBox comboBox = new ComboBox();

        try {
            LinkedList<Patient> plist = PatientAdapter.retrieve();

            var iterator = plist.iterator();
            while (iterator.hasNext()) {
                Patient cur = iterator.next();
                comboBox.getItems().add(cur.getId() + ": " + cur.getLastName());
            }
        } catch (Exception e) { e.printStackTrace(); }

        ComboBox dateField = new ComboBox();
        try {
            dateField.getItems().add("Monday");
            dateField.getItems().add("Tuesday");
            dateField.getItems().add("Wednesday");
            dateField.getItems().add("Thursday");
            dateField.getItems().add("Friday");
            dateField.getItems().add("Saturday");
            dateField.getItems().add("Sunday");
        } catch (Exception e) { e.printStackTrace(); }


        this.getChildren().addAll(welcomeLabel,comboBox,acNameField,dateField,pAddedLabel,stFieldHr,stFieldMins,etFieldHr,etFieldMins,addActivity,exitButton);
        
        // Action handler make thing happen when button click

        addActivity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(new FileReader("./src/main/resources/activity.json"));
                    JSONArray pList = (JSONArray)obj;
                    
                    JSONObject jo = new JSONObject();
                    String pID[] = ((String)comboBox.getValue()).split(":");

                    if(pID[0].length() == 0){
                        pAddedLabel.setText("Patient not chosen");
                    } else if(!InputChecker.checkHour(stFieldHr.getText())){
                        pAddedLabel.setText("invalid start hour");

                    } else if(!InputChecker.checkHour(etFieldHr.getText())){
                        pAddedLabel.setText("invalid end hour");

                    } else if(!InputChecker.checkMinute(stFieldMins.getText())){
                        pAddedLabel.setText("invalid start minute");

                    } else if(!InputChecker.checkMinute(etFieldMins.getText())){
                        pAddedLabel.setText("invalid end minute");

                    } else if (!InputChecker.checkTime(stFieldHr.getText(), etFieldHr.getText(), stFieldMins.getText(), etFieldMins.getText())){ 
                        pAddedLabel.setText("impossible time");
                    } else if(!InputChecker.checkActivity(pID[0], (String)dateField.getValue(), stFieldHr.getText(), etFieldHr.getText(), stFieldMins.getText(), etFieldMins.getText())){
                        pAddedLabel.setText("actvity is in another activities time frame");

                    } else {
                        jo.put("patientID", pID[0]);
                        jo.put("acName", acNameField.getText()); 
                        jo.put("dt", (String)dateField.getValue());
                        jo.put("sthr", stFieldHr.getText());
                        jo.put("stmin", stFieldMins.getText());
                        jo.put("ethr", etFieldHr.getText());
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
                        Activity newAc = new Activity.Builder(acNameField.getText()).start(startHour, startMins).end(endHour, endMins).build();
                    }
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
