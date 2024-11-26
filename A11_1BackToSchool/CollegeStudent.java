/**
 * CollegeStudent class that extends Student, with two new fields, string major
 * and int year, each with getters, setters, and an overall unique toString
 * 
 * @author Rohan Chaudhary
 * @version 10-31-2024
 */
public class CollegeStudent
    extends Student
{
    private String major;
    private int    year;

    /**
     * Constructs new CollegeStudent with a string name, int age, string gender,
     * string idNum, double GPA, string major, int year
     * 
     * @param myName
     *            string name input
     * @param myAge
     *            int age input
     * @param myGender
     *            string gender input
     * @param myIdNum
     *            string id input
     * @param myGPA
     *            double GPA input
     * @param myYear
     *            int year input
     * @param myMajor
     *            string major input
     */
    public CollegeStudent(
        String myName,
        int myAge,
        String myGender,
        String myIdNum,
        double myGPA,
        int myYear,
        String myMajor)
    {
        super(myName, myAge, myGender, myIdNum, myGPA);
        major = myMajor;
        year = myYear;
    }


    /**
     * sets new major based on string input
     * 
     * @param myMajor
     *            string val of new major
     */
    public void setMajor(String myMajor)
    {
        major = myMajor;
    }


    /**
     * sets new year based on int input
     * 
     * @param myYear
     *            int val of new year
     */
    public void setYear(int myYear)
    {
        year = myYear;
    }


    /**
     * returns current string major
     * 
     * @return string val of major
     */
    public String getMajor()
    {
        return major;
    }


    /**
     * returns current int year
     * 
     * @return int val of year
     */
    public int getYear()
    {
        return year;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + year + ", major: " + major;
    }
}
