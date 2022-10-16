package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.*;
//import org.json.simple.*;
//import org.json.simple.parser.*;

public class AddPatientPane extends VBox {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Add Patient";

    public AddPatientPane(Stage stage) {
        // Set up screen elements
        this.setSpacing(10);
        Label welcomeLabel = new Label("Welcome to the 'add patient' wizard.");
        TextField pNameField = new TextField("Enter name here");
        Button addPatientButton = new Button("Add Patient");
        Button exitButton = new Button("Exit without saving");
        this.getChildren().addAll(welcomeLabel,pNameField,addPatientButton,exitButton);
        
        // Action handler make thing happen when button click

        addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // create a writer
                    //BufferedWriter writer = Files.newBufferedWriter(Paths.get("book.json"));

                    // create book object
                    //Book book = new Book("Thinking in Java", "978-0131872486", 1998, new String[] {"Bruce Eckel"});

                    // convert book object to JSON and write to book.json
                    //Jsoner.serialize(book, writer);

                    // close the writer
                    //writer.close();
                } catch (Exception e) { return; }
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
