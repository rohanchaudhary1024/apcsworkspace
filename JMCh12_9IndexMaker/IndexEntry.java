import java.util.ArrayList;

/**
 * Class holding an index for a single word, containing the word and the lines
 * which it appears in, with getters for the word, and methods to add indexes to
 * it, along with a tostring.
 * 
 * @author Rohan Chaudhary
 * @version 11-20-2024
 */
public class IndexEntry
{
    private String             word;
    private ArrayList<Integer> numsList;

    /**
     * Constructs an IndexEntry for a given word (converted to upper case); sets
     * numsList to an empty ArrayList.
     * 
     * @param word
     *            word arraylist is constructed for
     */
    public IndexEntry(String word)
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }


    /**
     * Returns the word of this IndexEntry object.
     * 
     * @return word of the IndexEntry object
     */
    public String getWord()
    {
        return word;
    }


    /**
     * If num is not already in the list, adds num at the end of this
     * IndexEntry's list
     * 
     * @param num
     *            number to be added (if not duplicate)
     */
    public void add(int num)
    {
        Integer numTemp = num;
        if (!(numsList.contains(numTemp)))
        {
            numsList.add(num);
        }
    }


    /**
     * Converts this IndexEntry into a string in the following format: the word
     * followed by a space, followed by numbers separated by a comma and a
     * space.
     * 
     * @return String conversion
     */
    public String toString()
    {
        String outputString = "";
        outputString += word + " ";
        for (int i = 0; i < numsList.size(); i++)
        {
            if (i > 0)
            {
                outputString += ", ";
            }
            outputString += numsList.get(i);
        }
        return outputString;
    }
}
