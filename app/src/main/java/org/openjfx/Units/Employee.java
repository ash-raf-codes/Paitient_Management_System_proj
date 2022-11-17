package org.openjfx.Units;

import java.util.LinkedList;

public class Employee extends Person 
{
    private LinkedList<String> Patients;

    public static class Builder {
        //required
        private String fn;
        private String ln;
        private final String id;
        private  String dob;
    
        public Builder(String id) {
          this.id = id;
        }
    
        public Builder fn(String first) {
            fn = first;
            return this;
        }
    
        public Builder ln(String last) {
            ln = last;
            return this;
          }

        public Builder dob(String dateOfBirth) {
            dob = dateOfBirth;
            return this;
          }

    
        public Employee build() {
          return new Employee(this);
        }
      }

      public Employee(Builder builder)
    {
        setName(builder.fn, builder.ln);
        setID(builder.id);
        setDOB(builder.dob);
        this.Patients = new LinkedList<String>();
        setAdapter(new CareWorkerAdapter());
    }


    // public void setEmployeeID(String id)
    // {
    //     setID(id);
    // }

    public void setPatientList(LinkedList<String> p)
    {
      this.Patients = p;
    }
    
    public void addPatient(String newPatient)
    {
        this.Patients.add(newPatient);
    }

    public void removePatient(String pRemove)
    {
        this.Patients.remove(pRemove);
    }

    public LinkedList<String> getPatientList()
    {
        return this.Patients;
    }

    public String toString()
    {
      return getId() + "\t\tFull name: " + getFirstName() + " " + getLastName() 
              + ", Date of birth: " + getDob()
              + "\n\t\t\t\tPatient List: " + Patients;
    }
}