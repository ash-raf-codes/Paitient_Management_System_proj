package org.openjfx.Units;

public class Person 
{
    private String firstName;
    private String lastName;
    private String id;
    private DOB dob;

    public void setName(String fn, String ln)
    {
        firstName = fn;
        lastName = ln;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setID(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setDOB(int year, int month, int day)
    {
        dob = new DOB(year, month, day);
    }

    public DOB getDob() 
    {
        return dob;
    }
}