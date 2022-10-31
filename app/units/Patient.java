public class Patient extends Person 
{
    String diagnosis;

    Patient(String fn, String ln, String id, int year, int month, int day, String diagnosis)
    {
        setName(fn, ln);
        setHealthCardNumber(id);
        setDOB(year, month, day);
        setDiagnosis(diagnosis);
    }

    void setHealthCardNumber(String id)
    {
        setID(id);
    }

    void setDiagnosis(String diagnosis)
    {
        this.diagnosis = diagnosis;
    }
}
