package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.openjfx.commands.*;

public class HomePane extends GridPane {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Home";

    public HomePane(Stage stage) {
        // Set attributes
        this.setVgap(20);
        this.setHgap(20);
        //this.setStyle("-fx-grid-lines-visible: true");

        // Set up screen elements
        Label welcomeLabel = new Label("Welcome to Rementi care home management system!");
        welcomeLabel.setId("welcomeLabel");
        this.add(welcomeLabel,0,0,3,1);

        // Column 1: Patient Management features
        VBox pmPane = new VBox();
        pmPane.setSpacing(20);
        this.add(pmPane,0,1,1,4);
        Label patientCatLabel = new Label("Patient Management");
        Button addPatientButton = new Button("Add Patient");
        Button viewPatientsButton = new Button("View Patient List");
        Button removePatientButton = new Button("Remove Patient");
        removePatientButton.setStyle("-fx-background-color: coral");
        pmPane.getChildren().addAll(patientCatLabel,addPatientButton,viewPatientsButton,removePatientButton);

        // Column 2: Worker Management features
        VBox wmPane = new VBox();
        wmPane.setSpacing(20);
        this.add(wmPane,1,1,1,3);
        Label workerCatLabel = new Label("Worker Management");
        Button addWorkerButton = new Button("Add Care Worker");
        Button viewWorkersButton = new Button("View Care Worker List");
        wmPane.getChildren().addAll(workerCatLabel,addWorkerButton,viewWorkersButton);

        // Column 3: Activity Management
        Label activityCatLabel = new Label("Activity Management");
        this.add(activityCatLabel,2,1);
        Button addActivityButton = new Button("Add New Type of Activity");
        this.add(addActivityButton,2,2);

        // Column 4: Schedule Management
        Label schedulerCatLabel = new Label("Schedule Management");
        this.add(schedulerCatLabel,3,1);
        Button schedulerButton = new Button("View and Edit Patient Schedules");
        this.add(schedulerButton,3,2);

        // Quit button
        Button quitButton = new Button("Quit");
        quitButton.setStyle("-fx-background-color: violet; -fx-font-weight: bold");
        this.add(quitButton,0,6);

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

        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Platform.exit();
                } catch (Exception e) { return; }
            }
        });  // Note this weird }); for action handlers
    }
    
}
