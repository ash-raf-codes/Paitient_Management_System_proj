package org.openjfx.Units;

import java.util.LinkedList;

public class Employee extends Person 
{
    private LinkedList<Patient> patients;

    public Employee(String fn, String ln, String id, int year, int month, int day)
    {
        setName(fn, ln);
        setEmployeeID(id);
        setDOB(year, month, day);
        this.patients = new LinkedList<Patient>();
    }

    public void setEmployeeID(String id)
    {
        setID(id);
    }

    public void addPatient(Patient newPatient)
    {
        this.patients.add(newPatient);
    }

    public void removePatient(Patient patientToRemove)
    {
        this.patients.remove(patientToRemove);
    }

    public LinkedList<Patient> getPatientList()
    {
        return this.patients;
    }
}