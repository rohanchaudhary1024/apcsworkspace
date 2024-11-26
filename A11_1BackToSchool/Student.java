/**
 * Student class that extends person with a new string idnum field and a new
 * double GPA field, fitted with according setters, getters, and a unique
 * toString
 * 
 * @author Rohan Chaudhary
 * @version 10-31-2024
 */
public class Student
    extends Person
{
    private String myIdNum; // Student Id Number
    private double myGPA;   // grade point average

    /**
     * Initializes new Student object, specifically the string field name, int
     * field age, string field gender, string field idnum, and double field GPA
     */
    public Student(String name, int age, String gender, String idNum, double gpa)
    {
        // use the super class' constructor
        super(name, age, gender);

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }


    /**
     * returns the idNum field of the student
     * 
     * @return string idNum field
     */
    public String getIdNum()
    {
        return myIdNum;
    }


    /**
     * returns the GPA field of the student
     * 
     * @return double GPA val
     */
    public double getGPA()
    {
        return myGPA;
    }


    /**
     * sets new idNum val
     * 
     * @param idNum
     *            new String idNum val
     */
    public void setIdNum(String idNum)
    {
        myIdNum = idNum;
    }


    /**
     * sets new GPA val
     * 
     * @param gpa
     *            new double GPA val
     */
    public void setGPA(double gpa)
    {
        myGPA = gpa;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " + myIdNum + ", gpa: " + myGPA;
    }
}
