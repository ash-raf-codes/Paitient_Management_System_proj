package org.openjfx.Units;

public class Schedule
{
    private DayPlan[] weekPlan;

    enum DayofWeek {
        MONDAY(0),
        TUESDAY(1),
        WEDNESDAY(2),
        THURSDAY(3),
        FRIDAY(4),
        SATURDAY(5),
        SUNDAY(6);

        private int value;

        private DayofWeek(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

    public Schedule()
    {
        DayPlan[] wp = new DayPlan[7];
        for(int i=0; i<7; i++)
        {
            wp[i] = new DayPlan();
        }
        setPlan(wp);
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


    public void addToPlan (Activity newact)
    {
        int d = getEnum(newact.getDate()).getValue();
        this.weekPlan[d].addActivity(newact);
    }
    
    public void addToPlan (Activity newact, int day)
    {
        this.weekPlan[day].addActivity(newact);
    }

    public DayPlan getDayPlan (int day)
    {
        return weekPlan[day];
    }

    public DayofWeek getEnum(String str)
    {
        if(str.equals("Monday"))
        {
            return DayofWeek.MONDAY;
        }
        else if(str.equals("Tuesday"))
        {
            return DayofWeek.TUESDAY;
        }
        else if(str.equals("Wednesday"))
        {
            return DayofWeek.WEDNESDAY;
        }
        else if(str.equals("Thursday"))
        {
            return DayofWeek.THURSDAY;
        }
        else if(str.equals("Friday"))
        {
            return DayofWeek.FRIDAY;
        }
        else if(str.equals("Saturday"))
        {
            return DayofWeek.SATURDAY;
        }
        else
        {
            return DayofWeek.SUNDAY;
        }
    }
}