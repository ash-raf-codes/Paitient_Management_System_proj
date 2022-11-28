package org.openjfx.Units;

import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.util.LinkedList;

public class ActivityAdapter {
    public static LinkedList<Activity> retrieve()
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/activity.json"));
            JSONArray jsonarray = (JSONArray)obj;
            var iterator = jsonarray.iterator();
            LinkedList<Activity> activities = new LinkedList<Activity>();
            for(int i=0; i<jsonarray.size(); i++)
            {
                JSONObject cur = (JSONObject)jsonarray.get(i);
                Activity a = new Activity.Builder(cur.get("acName").toString())
                                        .date(cur.get("dt").toString())
                                        .patient(cur.get("patientID").toString())
                                        .start(Integer.parseInt(cur.get("sthr").toString()),Integer.parseInt(cur.get("stmin").toString()))
                                        .end(Integer.parseInt(cur.get("ethr").toString()), Integer.parseInt(cur.get("etmin").toString())).build();
                //a.setPatientList(patients);
                activities.add(a);
            }
            
            return activities;
        } catch (Exception e) { 
            e.printStackTrace();
            return null; 
        }
        
    }
}
