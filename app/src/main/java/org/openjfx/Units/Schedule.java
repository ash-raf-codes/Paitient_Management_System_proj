package org.openjfx.Units;

public class Schedule
{
    private DayPlan[] weekPlan;
    //TODO schedule should be attached to a patient

    public Schedule()
    {
        this.weekPlan = new DayPlan[7];
    }

    public Schedule (DayPlan[] plan)
    {
        setPlan(plan);
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
}