package org.openjfx.Units;

import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.util.LinkedList;

public class CareWorkerAdapter implements Adapter
{
    public void store(Person p)
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/careworkers.json"));
            JSONArray pList = (JSONArray)obj;
            
            JSONObject jo = new JSONObject();
            jo.put("FirstName", p.getFirstName()); 
            jo.put("LastName", p.getLastName()); 
            jo.put("DOB", p.getDob());
            jo.put("ID", p.getId());
            jo.put("PatientList", ((Employee)p).getPatientList());
            pList.add(jo);
            
            FileWriter pw = new FileWriter("./src/main/resources/careworkers.json"); 
            pw.write(pList.toJSONString()); 
            pw.flush(); 
            pw.close(); 
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static LinkedList<Employee> retrieve()
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/careworkers.json"));
            JSONArray pList = (JSONArray)obj;
            LinkedList<Employee> plist = new LinkedList<Employee>();
            for(int i=0; i<pList.size(); i++)
            {
                JSONObject cur = (JSONObject)pList.get(i);
                LinkedList<String> patients = CareWorkerAdapter.getStringAsLinkedList(cur.get("PatientList").toString());
                Employee e = new Employee.Builder(cur.get("ID").toString())
                                        .fn(cur.get("FirstName").toString())
                                        .ln(cur.get("LastName").toString())
                                        .dob(cur.get("DOB").toString()).build();
                e.setPatientList(patients);
                plist.add(e);
            }

            return plist;
        } catch (Exception e) { 
            e.printStackTrace();
            return null; 
        }
    }

    //Adds passed in patient id to patient list of employee with
    //passed in employee id
    public static void addPatientToEmployee(String empID, String pID)
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("./src/main/resources/careworkers.json"));
            JSONArray pList = (JSONArray)obj;
            for(int i=0; i<pList.size(); i++)
            {
                JSONObject cur = (JSONObject)pList.get(i);
                if(cur.get("ID").equals(empID))
                {
                    LinkedList<String> templist = getStringAsLinkedList(cur.get("PatientList").toString());
                    templist.add(pID);
                    cur.remove("PatientList");
                    cur.put("PatientList", templist);

                    FileWriter pw = new FileWriter("./src/main/resources/careworkers.json"); 
                    pw.write(pList.toJSONString()); 
                    pw.flush(); 
                    pw.close(); 
                }

            } 
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }

    //Takes Patient list string from json file and turns it into LinkedList
    private static LinkedList<String> getStringAsLinkedList(String str)
    {
        if(str.equals("[]"))
        {
            return new LinkedList<String>();
        } 
        else
        {
            String[] parts = str.replace("[","")
                                .replace("]","")
                                .split(",");
            LinkedList<String> templist = new LinkedList<String>();
            for(int j=0; j<parts.length; j++)
                {
                    templist.add(parts[j].replace("\"", ""));
                }
            return templist;
        } 
    }

}
