package org.openjfx.Units;

import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.util.LinkedList;


public class PatientAdapter {

    public static void storePatient(Patient p)
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/patients.json"));
            JSONArray pList = (JSONArray)obj;
            
            JSONObject jo = new JSONObject();
            jo.put("FirstName", p.getFirstName()); 
            jo.put("LastName", p.getLastName()); 
            jo.put("DOB", p.getDob());
            pList.add(jo);
            
            FileWriter pw = new FileWriter("./src/main/resources/patients.json"); 
            pw.write(pList.toJSONString()); 
            pw.flush(); 
            pw.close(); 
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static LinkedList<Patient> retrievePatients()
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/patients.json"));
            JSONArray pList = (JSONArray)obj;
            var iterator = pList.iterator();
            LinkedList<Patient> plist = new LinkedList<Patient>();
            while (iterator.hasNext()) {
                String cur = iterator.next().toString();
                String[] parts = cur.split(",");
                
                String[] fname  = parts[0].split(":");
                String[] DOB  = parts[1].split(":");
                String[] lname = parts[2].split(":");

                plist.add(new Patient(fname[1].replace("\"", ""), lname[1].replace("\"", "").replace("}", ""), "123456", DOB[1].replace("\"", ""), "diagnosis"));
            }
            return plist;
        } catch (Exception e) { 
            e.printStackTrace();
            return null; 
        }
        
    }
}
    

