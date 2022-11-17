package org.openjfx.Units;

public class Patient extends Person 
{
    private Schedule schedule;
    private String careWorker;

    public Patient(String fn, String ln, String id, String dob, Employee cw)
    {
        setName(fn, ln);
        setHealthCardNumber(id);
        setDOB(dob);
        setSchedule(new Schedule());
        setAdapter(new PatientAdapter());
    }

    public Patient(String fn, String ln, String id, String dob)
    {
        setName(fn, ln);
        setHealthCardNumber(id);
        setDOB(dob);
        setSchedule(new Schedule(this));
        setAdapter(new PatientAdapter());
    }

    public String getHealthCardNumber()
    {
        return this.getId();
    }
    public void setHealthCardNumber(String id)
    {
        setID(id);
    }


    public Schedule getSchedule()
    {
        return this.schedule;
    }
    public void setSchedule(Schedule newSchedule)
    {
        this.schedule = newSchedule;
    }

    public String getCareWorker() 
    {
        return careWorker;
    }
    public void setCareWorker(String careWorker) 
    {
        this.careWorker = careWorker;
    }

    public String toString() {
        return getId() + "\t\tFull name: " + getFirstName() + " " + getLastName() + ", Date of birth: " + getDob();
    }
}
