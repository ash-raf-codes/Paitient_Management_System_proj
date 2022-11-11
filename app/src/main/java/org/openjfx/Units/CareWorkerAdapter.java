package org.openjfx.Units;

import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.util.LinkedList;

public class CareWorkerAdapter {
    public static void storeWorker(Patient p)
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/careworkers.json"));
            JSONArray pList = (JSONArray)obj;
            
            JSONObject jo = new JSONObject();
            jo.put("FirstName", p.getFirstName()); 
            jo.put("LastName", p.getLastName()); 
            jo.put("DOB", p.getDob());
            jo.put("iD", p.getId());
            pList.add(jo);
            
            FileWriter pw = new FileWriter("./src/main/resources/careworkers.json"); 
            pw.write(pList.toJSONString()); 
            pw.flush(); 
            pw.close(); 
        } catch (Exception e) { e.printStackTrace(); }
    }

    /* 
    ** This method needs to be implemented properly**

    public static LinkedList<Employee> retrieveEmployees()
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/careworkers.json"));
            JSONArray pList = (JSONArray)obj;
            var iterator = pList.iterator();
            LinkedList<Employee> plist = new LinkedList<Employee>();
            while (iterator.hasNext()) {
                String cur = iterator.next().toString();
                String[] parts = cur.split(",");
                
                String[] fname  = parts[0].split(":");
                String[] DOB  = parts[1].split(":");
                String[] lname = parts[2].split(":");

                *** The following line needs to be formatted correctly ***

                plist.add(new Patient(fname[1].replace("\"", ""), lname[1].replace("\"", "").replace("}", ""), "123456", DOB[1].replace("\"", ""), "diagnosis"));
            }
            return plist;
        } catch (Exception e) { 
            e.printStackTrace();
            return null; 
        }
        
    }
    */
}
