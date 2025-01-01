import java.util.*;

/**
 * Java Methods Chapter 10 Exercises 2, 6 - 11, 14 - 15, 20 & 22
 * 
 * @author Rohan Chaudhary
 * @version 10-16-2024
 * @author Period - 1
 * @author Assignment - Ch10Exercises
 * @author Sources - N/A
 */
public class JMCh10Exercises
{
    Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner(System.in);
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public JMCh10Exercises(String str)
    {
        scan = new Scanner(str);
    }


    // 10-2(a)
    public boolean endsWithStar(String s)
    {
        return(s.endsWith("*"));
    }


    // 10-2(b)
    public boolean endsWith2Stars(String s)
    {
        if (s.length() > 1 && s.charAt(s.length() - 1) == '*' && s.charAt(s.length() - 2) == '*')
        {
            return true;
        }
        return false;
    }


    // 10-6
    public String scroll(String s)
    {
        String outputStr = s;
        if (s.length() > 1) {
            outputStr = s.substring(1) + s.charAt(0);
        }
        return outputStr;
    }


    // 10-7
    public String convertName(String name)
    {
        String outputString;
        char temp;
        int nameEnd = -1;
        for (int i = 0; i < name.length(); i++)
        {
            temp = name.charAt(i);
            if (temp == ',')
            {
                nameEnd = i;
                break;
            }
        }
        outputString = name.substring(nameEnd + 2) + " " + name.substring(0, nameEnd);
        return outputString.trim();
    }


    // 10-8
    public String negate(String str)
    {
        String outputString = str.replace("0", "j");
        outputString = outputString.replace("1", "k");
        outputString = outputString.replace("j", "1");
        outputString = outputString.replace("k", "0");
        return outputString;
    }


    // 10-9
    public boolean isConstant(String s)
    {
        String searchChar = Character.toString(s.charAt(0)); // Nothing saying I
                                                             // can't use
                                                             // Character
                                                             // methods
        s = s.replace(searchChar, "");
        boolean outputBool = s.isEmpty();
        return outputBool; // There has to be a neater way to do this... no
                           // iteration makes me cry
    }


    // 10-10
    public String removeComment(String str)
    {
        int indTwo = str.indexOf("*/");
        int indOne = str.indexOf("/*");
        //System.out.println(indOne + " " + indTwo);
        if (indOne == -1 || indTwo == -1 || indOne>= indTwo)
        {
            return str;
        }
        return (str.substring(0, indOne) + str.substring(indTwo + 2));
    }


    // 10-11
    public String cutOut(String s, String s2)
    {
        String outputString = s;
        int ind = s.indexOf(s2);
        if (ind != -1) {
            outputString = s.substring(0, ind) + s.substring(ind + s2.length());
        }

        return outputString;
    }


    // 10-14
    public String removeHtmlTags(String str)
    {
        boolean tagOpen1 = false, tagClose1 = false;
        int openTagOne = -1;
        int closeTagOne = -1;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '<' && tagOpen1 == false)
            {
                tagOpen1 = true;
                openTagOne = i;
            }
            else if (str.charAt(i) == '>' && tagClose1 == false)
            {
                tagClose1 = true;
                closeTagOne = i;
            }
        }
        String tagContent = str.substring(openTagOne + 1, closeTagOne);

        boolean tagOpen2 = false, tagClose2 = false;
        int openTagTwo = -1;
        int closeTagTwo = -1;
        for (int i = closeTagOne + 1; i < str.length(); i++)
        {
            if (str.charAt(i) == '<' && tagOpen2 == false)
            {
                tagOpen2 = true;
                openTagTwo = i;
            }
            else if (str.charAt(i) == '>' && tagClose2 == false)
            {
                tagClose2 = true;
                closeTagTwo = i;
            }
        }
        /*
         * System.out.println(tagOpen1); System.out.println(tagOpen2);
         * System.out.println(tagClose1); System.out.println(tagClose2);
         * System.out.println(tagContent);
         * System.out.println(str.substring(openTagTwo+2, closeTagTwo));
         * System.out.println(openTagTwo); /*
         */

        if (tagOpen1 && tagOpen2 && tagClose1 && tagClose2)
        {
            // System.out.println("Step One!");
            if (tagContent.equals(str.substring(openTagTwo + 2, closeTagTwo)))
            {
                // System.out.println("Success!");
                return (str.substring(0, openTagOne) + str.substring(closeTagOne + 1, openTagTwo)
                    + str.substring(closeTagTwo + 1));
            }
        }

        return str;
    }


    // 10-15
    public boolean onlyDigits(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isDigit(s.charAt(i)))
            { // Nothing specified against using Character methods...
                return false;
            }
        }
        return true;
    }


    // 10-20
    public static boolean isValidISBN(String isbn)
    {
        int sum = 0;
        for (int i = 0; i < isbn.length(); i++)
        {
            if (isbn.charAt(i) == 10)
            {
                sum += 10;
                break;
            }
            sum += (10 - i) * Character.digit(isbn.charAt(i), 10);
        }
        return (sum % 11 == 0);
    }


    // 10-22
    public String shuffle(String s)
    {
        Random rand = new Random();
        StringBuffer shuffleStr = new StringBuffer(s);
        int n = shuffleStr.length();
        int tempI;
        char temp;
        while (n > 1)
        {
            tempI = rand.nextInt(n);
            temp = shuffleStr.charAt(tempI);
            shuffleStr.delete(tempI, tempI + 1);
            shuffleStr.insert(tempI, shuffleStr.charAt(n - 2)); // Insert nth
                                                                // char into
                                                                // spot
            shuffleStr.insert(n - 1, temp);
            shuffleStr.delete(n, n + 1);
            n--;
        }

        return shuffleStr.toString();
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println("Make a selection");
            System.out.println();
            System.out.println("   (1) 10-2(a) endsWithStar( String s )");
            System.out.println("   (2) 10-2(b) endsWith2Stars( String s )");
            System.out.println("   (3) 10-6 scroll( String s )");
            System.out.println("   (4) 10-7 convertName( String name )");
            System.out.println("   (5) 10-8 negate( String str )");
            System.out.println("   (6) 10-9 isConstant( String s )");
            System.out.println("   (7) 10-10 removeComment( String str )");
            System.out.println("   (8) 10-11 cutOut( String s, String s2 )");
            System.out.println("   (9) 10-14 removeHtmlTags( String str )");
            System.out.println("   (A) 10-15 onlyDigits( String s )");
            System.out.println("   (B) 10-20 isValidISBN( String isbn )");
            System.out.println("   (C) 10-22 shuffle( String s )");
            System.out.println("   (Q) Quit");
            System.out.println();
            System.out.print("Enter a choice:  ");
            String response = kbd.nextLine();

            if (response.length() > 0)
            {
                System.out.println();

                switch (response.charAt(0))
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println(
                            "endsWithStar(" + end1Star + ") = " + exercise.endsWithStar(end1Star));
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println(
                            "endsWithStar(" + ends0Star + ") = "
                                + exercise.endsWithStar(ends0Star));
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println(
                            "endsWith2Stars(" + end2Str + ") = "
                                + exercise.endsWith2Stars(end2Str));
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println(
                            "endsWith2Stars(" + endsWith1Star + ") = "
                                + exercise.endsWith2Stars(endsWith1Star));
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println(
                            "scroll(\"" + scrollStr + "\") --> " + "\"" + exercise.scroll(scrollStr)
                                + "\"");
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println(
                            "convertName(\"" + convStr + "\") --> " + "\""
                                + exercise.convertName(convStr) + "\"");
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println(
                            "negate(\"" + negStr + "\") --> " + "\"" + exercise.negate(negStr)
                                + "\"");
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println(
                            "isConstant(\"" + constStr1 + "\") = "
                                + exercise.isConstant(constStr1));
                        System.out.println(
                            "isConstant(\"" + constStr2 + "\") = "
                                + exercise.isConstant(constStr2));
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String failureTest = "*/ farmer john and bessie the cow /* int z = 0";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println(
                            "removeComment(\"" + comment + "\") --> " + "\""
                                + exercise.removeComment(comment) + "\"");
                        System.out.println(
                            "removeComment(\"" + failureTest + "\") --> " + "\""
                                + exercise.removeComment(failureTest) + "\"");
                        System.out.println(
                            "removeComment(\"" + notComment + "\") --> " + "\""
                                + exercise.removeComment(notComment) + "\"");
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println(
                            "cutOut(\"" + cutstr + "\", \"" + cutOutstr + "\") --> " + "\""
                                + exercise.cutOut(cutstr, cutOutstr) + "\"");
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println(
                            "removeHtmlTags(\"" + htmlStr + "\") --> " + "\""
                                + exercise.removeHtmlTags(htmlStr) + "\"");
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println(
                            "onlyDigits(\"" + digitStr + "\") = " + exercise.onlyDigits(digitStr));
                        System.out
                            .println("onlyDigits(\"" + dStr + "\") = " + exercise.onlyDigits(dStr));
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println(
                            "isValidISBN(\"" + validISBN + "\") = "
                                + exercise.isValidISBN(validISBN));
                        System.out.println(
                            "isValidISBN(\"" + invalidISBN + "\") = "
                                + exercise.isValidISBN(invalidISBN));
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println(
                            "shuffle(\"" + str + "\") --> " + "\"" + exercise.shuffle(str) + "\"");
                        System.out.println(
                            "shuffle(\"" + str + "\") --> " + "\"" + exercise.shuffle(str) + "\"");
                        break;
                    default:
                        if (response.toLowerCase().charAt(0) == 'q')
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print("Invalid Choice");
                        }
                        break;
                }
            }
        }
        while (!done);
        System.out.println("Goodbye!");
    }
}
