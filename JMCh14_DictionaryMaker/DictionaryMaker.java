import java.util.Scanner;
import java.io.*;

/**
 * Reads from an inputfile, processes string data with a certain amount of
 * length, sets it to uppercase, and writes it in uppercase. Methods to open the
 * input file and output file, and a method to process the data, combined with a
 * constructor.
 * 
 * @author Rohan Chaudhary
 * @version 11-27-2024
 * @author Period - 2
 * @author Assignment - JM Ch14 - DictionaryMaker
 * @author Sources - N/A
 */
public class DictionaryMaker
{
    private static final int  MINLENGTH = 3, MAXLENGTH = 5;
    public static Scanner     fileIn;       // public for test purposes
    public static PrintWriter fileOut;  // public for test purposes

    public static void main(String[] args)
        throws IOException
    {
        Scanner kboard = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter input file name: ");
        String fileName = kboard.next();

        openInputFile(fileName);
        if (fileIn == null)
        {
            System.out.println("*** Can't open " + fileName + " ***");
            return;
        }

        createOutputFile("RamblecsDictionary.java");
        if (fileOut == null)
        {
            fileIn.close();
            System.out.println("*** Can't create RamblecsDictionary.java ***");
            return;
        }

        int count = copyWords();
        System.out.println("Done: " + count + " words.");

        fileIn.close();
        fileOut.close();
    }


    /**
     * Opens a file fileName (in the current folder) and places a reference to
     * it into fileIn
     */
    public static void openInputFile(String fileName)
    {
        File f = new File(fileName);
        try
        {
            fileIn = new Scanner(f);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("cannot open " + fileName);
            System.exit(1);
        }
    }


    /**
     * Creates a new file fileName (in the current folder) and places a
     * reference to it into fileOut
     */
    public static void createOutputFile(String fileName)
    {
        try
        {
            File f = new File(fileName);
            fileOut = new PrintWriter(f);
        }
        catch (IOException ex)
        {
            System.out.println("Error, IOException");
        }

    }


    /**
     * Reads all words from fileIn, selects the words that have from MINLENGTH
     * to MAXLENGTH letters, converts them into upper case and writes the words
     * into fileOut in Java syntax
     * 
     * @return number of words processed
     */
    public static int copyWords()
    {
        int count = 0;
        String temp;
        fileOut.println("public class RamblecsDictionary\n{");
        fileOut.println("\tpublic String words[] =\n\t{");

        while (fileIn.hasNextLine())
        {
            temp = fileIn.nextLine();
            if (temp.length() >= MINLENGTH && temp.length() <= MAXLENGTH)
            {
                fileOut.println("\t\t\"" + temp.toUpperCase() + "\",") ;
            }
            count++;
        }

        fileOut.println("\t};");
        fileOut.println("}");

        return count;
    }
}
