/**
 * Teacher class that extends Person with two extra fields (string subject and
 * double salary), setters, getters, and unique toString method.
 * 
 * @author Rohan Chaudhary
 * @version 10-31-2024
 */
public class Teacher
    extends Person
{
    private String subject;
    private double salary;

    /**
     * Constructs a new Teacher object with name, age, gender, subject, and
     * salary
     * 
     * @param myName
     *            string name of new teacher object
     * @param myAge
     *            int age of new teacher object
     * @param myGender
     *            string gender of new teacher object
     * @param mySubject
     *            string subject of new teacher object
     * @param mySalary
     *            double salary of new teacher object
     */
    public Teacher(String myName,
        int myAge, String myGender, String mySubject, double mySalary)
    {
        super(myName, myAge, myGender);
        subject = mySubject;
        salary = mySalary;
    }


    /**
     * sets the subject field to the input String
     * 
     * @param mySubject
     *            String val of new subject
     */
    public void setSubject(String mySubject)
    {
        subject = mySubject;
    }


    /**
     * sets the salary field to the input double
     * 
     * @param mySalary
     *            double val of new salary
     */
    public void setSalary(double mySalary)
    {
        salary = mySalary;
    }


    /**
     * gets val of subject (string)
     * 
     * @return string val of subject
     */
    public String getSubject()
    {
        return subject;
    }


    /**
     * gets val of salary (double)
     * 
     * @return double val of salary
     */
    public double getSalary()
    {
        return salary;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + subject + ", salary: "
            + salary;
    }
}
