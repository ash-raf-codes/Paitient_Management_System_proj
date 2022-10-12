package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HomeScreen extends VBox {
    
    @FXML
    private Button addPatientButton;

    public HomeScreen() {
        //this.setSpacing(10);
        //addPatientButton = new Button("Add Patient");
        //HomeScreen.getChildren().addAll(addPatientButton);
    }
    
}
