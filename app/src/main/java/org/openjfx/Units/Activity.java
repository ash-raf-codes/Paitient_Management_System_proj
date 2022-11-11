package org.openjfx.Units;

import java.time.LocalTime;

public class Activity {
    
    private String actName;
    //private String firstName;
    //private String lastName;
    private LocalTime startTime;
    private LocalTime endTime;
    
    

    public static class Builder {
        //required
        private final String nm;
        private  LocalTime strt;
        private  LocalTime end;
    
        public Builder(String nm) {
          this.nm = nm;
        }
    
        public Builder start(LocalTime start) {
            strt = start;
            return this;
        }
    
        public Builder end(LocalTime et) {
            end = et;
            return this;
        }

    
        public Activity build() {
          return new Activity(this);
        }
      }

      public Activity(Builder build) 
    {
        actName = build.nm;
        startTime = build.strt;
        endTime = build.end;
    }
    

    // void setName (String newName) //These classes will be obsolete and will be removed once builder is set up
    // {
    //     this.actName = newName;
    // }

    // void setStartTime (LocalTime newstrt)//These classes will be obsolete and will be removed once builder is set up
    // {
    //     this.startTime = newstrt;
    // }

    // void setEndTime (LocalTime newend)//These classes will be obsolete and will be removed once builder is set up
    // {
    //     this.endTime = newend;
    // }

    public String toString ()
    {
        return actName + "\n " + startTime.toString() + " - " + endTime.toString();
    }

}
