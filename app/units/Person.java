public class Person 
{
    String firstName;
    String lastName;
    String id;
    DOB dob;

    void setName(String fn, String ln)
    {
        firstName = fn;
        lastName = ln;
    }

    void setID(String id)
    {
        this.id = id;
    }

    void setDOB(int year, int month, int day)
    {
        dob = new DOB(year, month, day);
    }
}