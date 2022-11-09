package org.openjfx.Units;

import java.time.LocalTime;

public class Activity {
    
    private String actName;
    private LocalTime startTime;
    private LocalTime endTime;

    public Activity( String nm, LocalTime strt, LocalTime end) 
    {
        setName(nm);
        setStartTime(strt);
        setEndTime(end);
    }

    void setName (String newName)
    {
        this.actName = newName;
    }

    void setStartTime (LocalTime newstrt)
    {
        this.startTime = newstrt;
    }

    void setEndTime (LocalTime newend)
    {
        this.endTime = newend;
    }

    public String toString ()
    {
        return actName + "\n " + startTime.toString() + " - " + endTime.toString();
    }

}
