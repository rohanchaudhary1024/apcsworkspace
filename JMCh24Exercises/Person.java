
/**
 * Question 24-20
 * 
 *  Write a hashCode method for this class that agrees with the equals method
 *  and returns different values for Persons of different ages.
 *
 *  @author  Rohan Chaudhary
 *  @version 2-25-2025
 *  @author  Period: 2
 *  @author  Assignment: JMCh24Exercises Question 20
 *
 *  @author  Sources: N/A
 */
public class Person
{
    private String name;
    private int age; // age <= 125

    public Person( String name, int age )
    {
        this.name = name;
        this.age = age;
    }

    public boolean equals( Object other )
    {
        if ( !( other instanceof Person ) )
        {
            return false;
        }
        Person otherPerson = (Person)other;
        return name.equals( otherPerson.name ) && age == otherPerson.age;
    }

    public int hashCode()
    {
    
        return name.hashCode() + age;
    }

}

