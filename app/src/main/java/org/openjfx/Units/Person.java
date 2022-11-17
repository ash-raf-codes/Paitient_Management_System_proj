package org.openjfx.Units;

import java.util.LinkedList;

public abstract class Person 
{
    private Adapter adapter;
    private String firstName;
    private String lastName;
    private String id;
    private String dob;

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

    public void setDOB(String dob)
    {
        this.dob = dob;
    }

    public String getDob() 
    {
        return dob;
    }

    public void setAdapter(Adapter adapter) 
    {
        this.adapter = adapter;
    }

    public void store()
    {
        adapter.store(this);
    }
}