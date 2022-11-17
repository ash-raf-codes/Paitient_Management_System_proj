package org.openjfx.Units;

import java.util.LinkedList;

public class Employee extends Person 
{
    private LinkedList<Employee> Employees;

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

    public String toString()
    {
      return getId() + "\t\tFull name: " + getFirstName() + " " + getLastName() + ", Date of birth: " + getDob();
    }
}