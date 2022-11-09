package org.openjfx.Units;

import java.util.LinkedList;

public class DayPlan {

    private LinkedList<Activity> activityList;

    public DayPlan (LinkedList<Activity> alist)
    {
        setAList(alist);
    }

    public void setAList (LinkedList<Activity> newList)
    {
        this.activityList = newList;
    }

    public void addActivity (Activity newact)
    {
        this.activityList.add(newact);
    }

    public void removeActivity (Activity remact)
    {
        this.activityList.removeFirstOccurrence(remact);
    }

    public String toString ()
    {
        String toReturn = "";
        for (int i=0; i<activityList.size(); i++)
        {
            toReturn = toReturn + activityList.get(i).toString();
        }
        return toReturn;
    }

    //TODO
    // - Sort activities by start time
    // - Prevent activities being added if they overlap, return error
    // - Remove activities by other methods also maybe (like index?)
}
