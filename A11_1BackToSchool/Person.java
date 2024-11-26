/**
 * Person class that holds string name, int age and string gender with setters,
 * getters, and a toString
 * 
 * @author Rohan Chaudhary
 * @version 10-31-2024
 */
public class Person
{
    private String myName;   // name of the person
    private int    myAge;       // person's age
    private String myGender; // 'M' for male, 'F' for female

    /**
     * Constructor that sets string name int age and string gender based on
     * input
     * 
     * @param name
     *            string name input
     * @param age
     *            int age input
     * @param gender
     *            string gender input
     */
    public Person(String name, int age, String gender)
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }


    /**
     * returns String name val
     * 
     * @return string name val
     */
    public String getName()
    {
        return myName;
    }


    /**
     * returns int age val
     * 
     * @return int age val
     */
    public int getAge()
    {
        return myAge;
    }


    /**
     * returns string gender field
     * 
     * @return sting gender field
     */
    public String getGender()
    {
        return myGender;
    }


    /**
     * sets name to input string val
     * 
     * @param name
     *            new string name val
     */
    public void setName(String name)
    {
        myName = name;
    }


    /**
     * sets age to new int age val
     * 
     * @param age
     *            new int age val
     */
    public void setAge(int age)
    {
        myAge = age;
    }


    /**
     * sets gender to new string gender val
     * 
     * @param gender
     *            new string gender val
     */
    public void setGender(String gender)
    {
        myGender = gender;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}
