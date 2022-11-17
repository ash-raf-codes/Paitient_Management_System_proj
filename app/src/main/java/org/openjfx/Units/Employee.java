package org.openjfx.Units;

import java.util.LinkedList;

public class Employee extends Person 
{
    String fn;
    String ln;
    String id;
    String dob;
    private LinkedList<Employee> Employees;

    // public Employee(String fn, String ln, String id, String dob)
    // {
    //     setName(fn, ln);
    //     setEmployeeID(id);
    //     setDOB(dob);
    //     this.Employees = new LinkedList<Employee>();
    //     setAdapter(new CareWorkerAdapter());
    // }

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
        fn = builder.fn;
        ln = builder.ln;
        id = builder.id;
        dob = builder.dob;
        this.Employees = new LinkedList<Employee>();
        setAdapter(new CareWorkerAdapter());
    }


    // public void setEmployeeID(String id)
    // {
    //     setID(id);
    // }

    public void addPatient(Employee newEmp)
    {
        this.Employees.add(newEmp);
    }

    public void removeEmployee(Employee empRemove)
    {
        this.Employees.remove(empRemove);
    }

    public LinkedList<Employee> getEmpList()
    {
        return this.Employees;
    }
}