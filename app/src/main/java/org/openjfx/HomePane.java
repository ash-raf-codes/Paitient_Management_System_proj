package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.openjfx.commands.*;

public class HomePane extends GridPane {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Home";

    public HomePane(Stage stage) {
        // Set spacing attributes
        this.setVgap(20);
        this.setHgap(10);

        // Set up screen elements
        Label welcomeLabel = new Label("Welcome to Rementi care home management system!");
        this.add(welcomeLabel,0,0,3,1);

        Button addPatientButton = new Button("Add Patient");
        this.add(addPatientButton,0,1);
        Button removePatientButton = new Button("Remove Patient");
        removePatientButton.setStyle("-fx-background-color: coral");
        this.add(removePatientButton,1,1);
        Button viewPatientsButton = new Button("View Patient List");
        this.add(viewPatientsButton,2,1);

        Button addWorkerButton = new Button("Add Care Worker");
        this.add(addWorkerButton,0,2);
        Button viewWorkersButton = new Button("View Care Worker List");
        this.add(viewWorkersButton,1,2);

        Button addActivityButton = new Button("Add New Type of Activity");
        this.add(addActivityButton,0,3);

        Button schedulerButton = new Button("View and Edit Patient Schedules");
        this.add(schedulerButton,0,4);

        //this.getChildren().addAll(welcomeLabel,addPatientButton,viewPatientsButton, addActivityButton);

        // Action handler make thing happen when button click
        addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SwitchToAddPatient addPatient = new SwitchToAddPatient();
                    addPatient.execute(stage);
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers

        viewPatientsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SwitchToViewPatients viewPatients = new SwitchToViewPatients();
                    viewPatients.execute(stage);
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers

        addWorkerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SwitchToAddWorker addWorker = new SwitchToAddWorker();
                    addWorker.execute(stage);
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers

        viewWorkersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SwitchToViewWorkers viewWorkers = new SwitchToViewWorkers();
                    viewWorkers.execute(stage);
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers

        addActivityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SwitchToAddActivity addActivity = new SwitchToAddActivity();
                    addActivity.execute(stage);
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers

        schedulerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SwitchToScheduler scheduler = new SwitchToScheduler();
                    scheduler.execute(stage);
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers
    }
    
}
