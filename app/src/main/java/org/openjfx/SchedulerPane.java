package org.openjfx;

import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.LocalTime;
import java.util.LinkedList;

import org.openjfx.Units.Activity;
import org.openjfx.Units.DayPlan;
import org.openjfx.Units.Schedule;
import org.openjfx.commands.SwitchToHome;

public class SchedulerPane extends GridPane {
    
    // The title that should always be on the window (stage) when this pane is active
    public static final String title = "Rementi: Scheduler";

    public SchedulerPane(Stage stage) {
        // FOR DEMO/TESTING PURPOSES ONLY
        // Set up sample schedule
        Activity spinClass = new Activity("Spin Class", LocalTime.of(10,15), LocalTime.of(11,0));
        LinkedList<Activity> alist = new LinkedList<Activity>();
        alist.add(spinClass);
        DayPlan sampleDay = new DayPlan(alist);
        Schedule sampleSched = new Schedule();
        for (int i=0; i<7; i++){
            sampleSched.addToPlan(sampleDay, i);
        } 

        // Set spacing attributes
        this.setVgap(20);
        this.setHgap(10);

        // Set up screen elements
        Label welcomeLabel = new Label("Welcome to Rementi schedule management system!");
        this.add(welcomeLabel,0,0,7,1);

        // Set up labels for weekdays
        Label mondayLabel = new Label("Monday");
        this.add(mondayLabel,0,1);
        Label tuesdayLabel = new Label("Tuesday");
        this.add(tuesdayLabel,1,1);
        Label wednesdayLabel = new Label("Wednesday");
        this.add(wednesdayLabel,2,1);
        Label thursdayLabel = new Label("Thursday");
        this.add(thursdayLabel,3,1);
        Label fridayLabel = new Label("Friday");
        this.add(fridayLabel,4,1);
        Label saturdayLabel = new Label("Saturday");
        this.add(saturdayLabel,5,1);
        Label sundayLabel = new Label("Sunday");
        this.add(sundayLabel,6,1);

        // Display sample schedule
        for (int i=0; i<7; i++){
            Label schedLabel = new Label(sampleSched.getDayPlan(i).toString());
            this.add(schedLabel,i,2);
        }

        // Set up exit button
        Button exitButton = new Button("Exit");
        this.add(exitButton,0,7);

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
    }
    
}
