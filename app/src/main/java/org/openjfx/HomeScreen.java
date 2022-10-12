package org.openjfx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HomeScreen extends VBox {
    
    @FXML
    private Button addPatientButton;

    public HomeScreen() {
        // The below code is an example of how you might manually set up action handlers
        //this.setSpacing(10);
        //addPatientButton = new Button("Add Patient");
        //HomeScreen.getChildren().addAll(addPatientButton);


        // Action handler to make thing happen when button clicked
        /*
        addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Logic of how to switch scenes here. Can't, because visibility :(
                } catch (Exception e) { return; }
            }
        }*/
    }
    
}
