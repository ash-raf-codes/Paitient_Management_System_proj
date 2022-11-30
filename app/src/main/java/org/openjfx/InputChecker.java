package org.openjfx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import org.openjfx.Units.CareWorkerAdapter;
import org.openjfx.Units.*;

public class InputChecker {
    
    // VALIDATION FUNCTIONS

    public static boolean checkDate(String date){

        //check format
        if(!date.matches("\\d{4}-\\d{2}-\\d{2}")){return false;}
        //check valid 
        SimpleDateFormat dateValidator = new SimpleDateFormat("yyyy-MM-dd");
        dateValidator.setLenient(false);
        try{
            dateValidator.parse(date);
            return true;
        } catch (ParseException ex){
            return false;
        }
    }
    public static boolean checkName(String name){
        if(name.length() == 0) {return false;}
        for(int i = 0; i < name.length() ; i++){
            if(!Character.isAlphabetic(name.charAt(i))){return false;}
        }
        
        return true;
    }
    public static boolean checkHour(String hour){
        if(hour.length() > 2){return false;}
        int hour_num = Integer.parseInt(hour);
        if(hour_num < 0 || hour_num > 23){return false;} 
        
        return true;
    }
    public static boolean checkMinute(String minute){
        if(minute.length() > 2){return false;}
        int minute_num = Integer.parseInt(minute);
        if(minute_num < 0 || minute_num > 59){return false;} 
        
        return true;
    }
    //integers or letters.
    public static boolean checkID(String id){
        if(id.length() == 0) {return false;}
        for(int i = 0 ; i < id.length() ; i++){
            if(!Character.isAlphabetic(id.charAt(i)) 
            && !Character.isDigit(id.charAt(i))){return false;}
        }
        
        return true;
    } 

    public static boolean checkTime(String stHR, String endHR, String stMIN, String endMin){

        if(Integer.parseInt(stHR) > Integer.parseInt(endHR)){
            return false;
        }
        if (Integer.parseInt(endHR) < Integer.parseInt(stHR)){
            return false;
        }
        if(Integer.parseInt(stHR) == Integer.parseInt(endHR)){
            if(Integer.parseInt(stMIN) > Integer.parseInt(endMin)){
                return false;
            }
        }

        return true;
    }
    // DUPLICATE CHECK FUNCTIONS

    
    //here check the list of care workers for any that match curr
    public static boolean checkWorker(String id){
        LinkedList<Employee> workerList = CareWorkerAdapter.retrieve();
        
        var iterator = workerList.iterator();
        while(iterator.hasNext()){
            Employee curr = iterator.next();
            if(curr.getId().equals(id)){return false;}
        }

        return true;
    }

    public static boolean checkPatient(String id){
        LinkedList<Patient> plist = PatientAdapter.retrieve();

        var iterator = plist.iterator();
        while(iterator.hasNext()){
            Patient curr = iterator.next();
            if(curr.getId().equals(id)){return false;}
        }        
        return true;
    }
    public static boolean checkPatientInWorker(String empID, String patID){
        LinkedList<Employee> workerList = CareWorkerAdapter.retrieve();
        
        var iterator = workerList.iterator();
        while(iterator.hasNext()){
            Employee curr = iterator.next();
            if(curr.getId().equals(empID)){
                LinkedList<String> plist = curr.getPatientList();

                var piterator = plist.iterator();
                while(piterator.hasNext()){
                    String p = piterator.next();
                    if(p.equals(patID)){return false;}
                }
            }
        }

        return true;
    }

    public static boolean checkActivity(String id, String date, String sthr
    , String endhr, String stmin, String endmin){
        LinkedList<Activity> alist = ActivityAdapter.retrieve();

        var iterator = alist.iterator();
        while(iterator.hasNext()){
            Activity act = iterator.next();
            
            if(act.getPatientID().equals(id)){
                //if the days are the same
                if(act.getDate().equals(date)){
                    int startHour = Integer.parseInt(sthr);
                    int endHour = Integer.parseInt(endhr);
                    int startMinute = Integer.parseInt(stmin);
                    int endMinute = Integer.parseInt(endmin);

                    if((startHour >= act.getSTHR() && startHour <= act.getENDHR())
                    || (endHour >= act.getSTHR() && endHour <= act.getENDHR())){
                        return false;
                    }
                    if((startHour < act.getSTHR() && startHour < act.getENDHR())
                    && (endHour > act.getSTHR() && endHour > act.getENDHR())){
                        return false;
                    }

                    if(startHour == act.getSTHR() && startMinute > act.getSTMIN()){
                        return false;
                    } 
                    if(startHour == act.getENDHR() && startMinute > act.getENDMIN()){
                        return false;
                    }
                    if(endHour == act.getSTHR() && endMinute > act.getSTMIN()){
                        return false;
                    } 
                    if(endHour == act.getENDHR() && endMinute > act.getENDMIN()){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
