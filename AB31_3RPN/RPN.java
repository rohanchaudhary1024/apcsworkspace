import java.util.*;

/**
 * RPN Calculator
 *
 * @author Rohan Chaudhary
 * @version 1-9-2024
 * @author Period: 2
 * @author Assignment: AB31RPN Calculator
 * @author Sources: N/A
 */
public class RPN
{
    Scanner                scan = new Scanner(System.in);

    private Stack<Integer> myStack;
    private Queue<String>  myQ;
    private String data = "";
    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }


    /**
     * **** Used for testing - Do Not Remove *** Constructs an RPN Calculator
     * and then redirects the Scanner input to the supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN(String console)
    {
        this();
        scan = new Scanner(console);
    }


    public void process() {
        int intOne = myStack.pop();
        int intTwo = myStack.pop();
        String operand = myQ.remove();
        System.out.println(operand);
        if (operand.equals("+")) {
            myStack.push(intOne + intTwo);
        }
        else if (operand.equals("-")) {
            myStack.push(intTwo - intOne);
        }
        else if (operand.equals("*")) {
            myStack.push(intOne * intTwo);
        }
        else {
            myStack.push(intTwo / intOne);
        }
    }

    public void print()
    {
        System.out.print(data);
        System.out.print("= " + myStack.pop());
    }


    public void calculate()
    {
        String temp;
        int tempI;
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                tempI = scan.nextInt();
                System.out.println(tempI);
                myStack.push(tempI);
                data += tempI + " ";
            }
            else {
                temp = scan.next();
                System.out.println(temp);
                if (temp.equals("q") || temp.equals("Q")) {
                    print();
                    return;
                }
                else {
                    data += temp + " ";
                    myQ.add(temp);
                    process();
                }
            }
        }
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}
