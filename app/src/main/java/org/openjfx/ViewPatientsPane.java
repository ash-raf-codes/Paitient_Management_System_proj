package org.openjfx;

import javafx.stage.Stage;
//import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;

import org.json.simple.parser.*;
import org.openjfx.commands.SwitchToHome;
import org.json.simple.JSONArray; 

public class ViewPatientsPane extends VBox {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: View Patients";

    public ViewPatientsPane(Stage stage) {
        // Set up screen elements
        this.setSpacing(10);
        Label welcomeLabel = new Label("Current Patients:");
        Label pListLabel = new Label("");
        Label clearedLabel = new Label("");
        Button exitButton = new Button("Exit");
        Button clearButton = new Button("Clear List [debug feature]");
        this.getChildren().addAll(welcomeLabel,pListLabel,clearButton,exitButton);

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/patients.json"));
            JSONArray pList = (JSONArray)obj;
            var iterator = pList.iterator();
            String pListString = "";
            while (iterator.hasNext()) {
                pListString = pListString + iterator.next().toString() + "\n";
            }
            pListLabel.setText(pListString);
        } catch (Exception e) { e.printStackTrace(); }
        
        // Action handler make thing happen when button click
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SwitchToHome home = new SwitchToHome();
                    home.execute(stage);
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers

        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FileWriter pw = new FileWriter("./src/main/resources/patients.json"); 
                    pw.write("[]"); 
                    pw.flush(); 
                    pw.close(); 
                    pListLabel.setText("");
                    clearedLabel.setText("List cleared");

                } catch (Exception e) { e.printStackTrace(); }
            }
        });  // Note this weird }); for action handlers
    }
}
