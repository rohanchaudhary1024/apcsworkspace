import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Coins: This class accepts a certain amount of monetary change (in cents). The
 * output is a list of the number of quarters, dimes, nickels, and pennies that
 * will make that amount of change with the least number of coins possible.
 *
 * @author Rohan Chaudhary
 * @version 8-27-2024
 * @author Period: 2
 * @author Assignment: Lab Activity 3.2 - Coins
 * @author Sources: N/A
 */
public class Coins
{
    private int myChange;
    
    /**
     * CONSTRUCTOR.
     * Initializes myChange with the integer parameter change, denominating 
     * the amount of change in cents that needs to be converted to coins
     * 
     * @param change The amount of change that needs to be converted to coins in cents as an integer. myChange is assigned with this val.
     */
    public Coins(int change)
    {
        myChange = change;
    }

    /**
     * Uses integer division and modulo logic to convert the amount of change
     * in cents to quarters, dimes, and nickles, with the least number of 
     * coins. Outputs the results, and sets myChange to zero.
     */
    public void calculate()
    {
        System.out.println(myChange + " cents =>");

        int quarters = myChange / 25;
        System.out.println("Quarter(s)\t" + quarters);
        myChange = myChange % 25;

        int dimes = myChange / 10;
        System.out.println("Dime(s) \t" + dimes);
        myChange = myChange % 10;

        int nickels = myChange / 5;
        System.out.println("Nickel(s)\t" + nickels);
        myChange = myChange % 5;

        int penny = myChange;
        System.out.println("Penny(s)\t" + penny);
        myChange = 0;
    }


    /**
     * Intended only for debugging.
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields)
        {
            try
            {
                str += separator + field.getType().getName() + " " + field.getName() + ":"
                    + field.get(this);
            }
            catch (IllegalAccessException ex)
            {
                System.out.println(ex);
            }
            separator = ", ";
        }
        return str + "]";
    }


    /**
     * Tester for the Coins class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        System.out.print("Please enter the number of cents --> ");
        int cents = console.nextInt();

        Coins change = new Coins(cents);
        change.calculate();
    }
}
