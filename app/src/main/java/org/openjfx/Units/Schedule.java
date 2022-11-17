package org.openjfx.Units;

public class Schedule
{
    private DayPlan[] weekPlan;
    private Patient patient;

    public Schedule()
    {
        setPlan(new DayPlan[7]);
        setPatient(new Patient("John","Doe","12345","1950-01-01","Old age"));
    }

    public Schedule(Patient p)
    {
        setPlan(new DayPlan[7]);
        setPatient(p);
    }

    public Schedule (DayPlan[] plan)
    {
        setPlan(plan);
    }

    public Schedule (DayPlan[] plan, Patient p)
    {
        setPlan(plan);
        setPatient(p);
    }

    public void setPlan (DayPlan[] newPlan)
    {
        this.weekPlan = newPlan;
    }

    public void addToPlan (DayPlan dayplan, int day)
    {
        this.weekPlan[day] = dayplan;
    }

    public void addToPlan (Activity newact, int day)
    {
        this.weekPlan[day].addActivity(newact);
    }

    public DayPlan getDayPlan (int day)
    {
        return weekPlan[day];
    }

    public Patient getPatient ()
    {
        return patient;
    }

    public void setPatient(Patient newPatient)
    {
        this.patient = newPatient;
    }
}