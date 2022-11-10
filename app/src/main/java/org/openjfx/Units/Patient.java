package org.openjfx.Units;

public class Patient extends Person 
{
    private String diagnosis;
    private Schedule schedule;
    private Employee careWorker;

    

    public Patient(String fn, String ln, String id, int year, int month, int day, String diagnosis, Employee cw)
    {
        setName(fn, ln);
        setHealthCardNumber(id);
        setDOB(year, month, day);
        setDiagnosis(diagnosis);
        setSchedule(new Schedule());
        setCareWorker(cw);
    }
    public Patient(String fn, String ln, String id, int year, int month, int day, String diagnosis)
    {
        setName(fn, ln);
        setHealthCardNumber(id);
        setDOB(year, month, day);
        setDiagnosis(diagnosis);
        setSchedule(new Schedule());
        setCareWorker(new Employee("Bob","Smith","98765",1990,01,01));
    }

    public String getHealthCardNumber()
    {
        return this.getId();
    }
    public void setHealthCardNumber(String id)
    {
        setID(id);
    }

    public String getDiagnosis() 
    {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public Schedule getSchedule()
    {
        return this.schedule;
    }
    public void setSchedule(Schedule newSchedule)
    {
        this.schedule = newSchedule;
    }

    public Employee getCareWorker() 
    {
        return careWorker;
    }
    public void setCareWorker(Employee careWorker) 
    {
        this.careWorker = careWorker;
    }
}
