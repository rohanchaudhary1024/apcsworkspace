import java.util.Scanner;

/**
 *  Prompts user for full name, then outputs a greeting towards that name.
 * 
 *  Outputs a statement prompting input of first name from the user. Takes
 *  in first name of user in String variable. Outputs statement prompting
 *  input of last name. Takes in last name of user in String variable. 
 *  Outputs greeting using the first and last name.
 *
 *  @author  Rohan Chaudhary
 *  @version 8-22-2024
 *  @author  Period: 2
 *  @author  Assignment: JMCh02_Hello - Greetings2.java
 *
 *  @author  Sources: N/A
 */
public class Greetings2
{
    public static void main(String[] args) {
        Scanner kboard = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = kboard.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = kboard.nextLine();
        System.out.println("Hello, " + firstName + " " + lastName);
        System.out.println("Welcome to Java!");
    }
}
