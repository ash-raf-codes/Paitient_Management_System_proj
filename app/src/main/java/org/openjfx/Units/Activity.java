package org.openjfx.Units;

import java.time.LocalTime;

public class Activity {
    
    private String actName;
    //private String firstName;
    //private String lastName;
    private LocalTime startTime;
    private LocalTime endTime;
    
    // This is the object class. It will be built using the AddActivityPane.java
    public Activity(String nm, LocalTime strt, LocalTime end) 
    {
        setName(nm);
        setStartTime(strt);
        setEndTime(end);
    }

    void setName (String newName) //These classes will be obsolete and will be removed once builder is set up
    {
        this.actName = newName;
    }

    void setStartTime (LocalTime newstrt)//These classes will be obsolete and will be removed once builder is set up
    {
        this.startTime = newstrt;
    }

    void setEndTime (LocalTime newend)//These classes will be obsolete and will be removed once builder is set up
    {
        this.endTime = newend;
    }

    public String toString ()
    {
        return actName + "\n " + startTime.toString() + " - " + endTime.toString();
    }

}
