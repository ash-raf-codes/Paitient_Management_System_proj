public class Employee extends Person 
{
    Employee(String fn, String ln, String id, int year, int month, int day)
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