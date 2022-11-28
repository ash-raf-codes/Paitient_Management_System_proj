package org.openjfx.Units;

import java.time.LocalTime;

public class Activity {
    
    private String actName;
    //private String firstName;
    //private String lastName;
    private int startTimeh;
    private int startTimem;
    private int endTimeh;
    private int endTimem;
    private String patient;
    private String date;
    
    

    public static class Builder {
        //required
        private final String nm;
        private  int strth;
        private  int strtm;
        private  int endh;
        private  int endm;
        private String p;
        private String d;
    
        public Builder(String nm) {
          this.nm = nm;
        }
    
        public Builder start(int hour, int min) {
            strth = hour;
            strth = min;
            return this;
        }
    
        public Builder end(int hour, int min) {
            endh = hour;
            endm = min;
            return this;
        }

        public Builder patient(String pt) {
          p = pt;
          return this;
        }

        public Builder date(String dt) {
          d = dt;
          return this;
        }

    
        public Activity build() {
          return new Activity(this);
        }
      }

      public Activity(Builder build) 
    {
        actName = build.nm;
        startTimeh = build.strth;
        startTimem = build.strtm;
        endTimeh = build.endh;
        endTimem = build.endm;
        patient = build.p;
        date = build.d;
    }

    public String getPatientID()
    {
      return patient;
    }

    public String getDate()
    {
      return date;
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
        return "\t" + actName + "\n\t\t" + startTimeh + ":" + startTimem + " - " + endTimeh + ":" + endTimem + "\n";
    }

}
