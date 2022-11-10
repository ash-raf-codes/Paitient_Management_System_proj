package org.openjfx.Units;

public class Employee extends Person 
{
    public Employee(String fn, String ln, String id, int year, int month, int day)
    {
        setName(fn, ln);
        setEmployeeID(id);
        setDOB(year, month, day);
    }

    void setEmployeeID(String id)
    {
        setID(id);
    }
}