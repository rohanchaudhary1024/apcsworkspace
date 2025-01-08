import java.util.ArrayList;

/**
 * Dictionary class for the names of words within a text file as well as the
 * line numbers from where they occur. that extends an ArrayList of the
 * associated IndexEntry class. Methods to add words individually, or to extract
 * and add them for a string, along with two contstructors, a default one and
 * one with an initial capacity.
 * 
 * @author Rohan Chaudhary
 * @version 11-20-2024
 */
public class DocumentIndex
    extends ArrayList<IndexEntry>
{
    /**
     * Default Constructor, creates class with default size.
     */
    public DocumentIndex()
    {
        super();
    }


    /**
     * Constructor which creates instance with an initial capacity
     * 
     * @param initialCapacity
     *            listed initial capacity
     */
    public DocumentIndex(int initialCapacity)
    {
        super(initialCapacity);
    }


    /**
     * If word is not yet in this DocumentIndex, creates a new IndexEntry for
     * word, and inserts it into this list in alphabetical order; adds num to
     * this word's IndexEntry by calling its add(num) method.
     * 
     * @param word
     *            string that is found or inserted
     * @param num
     *            associated number for found or inserted IndexEntry
     */
    //
    public void addWord(String word, int num)
    {
        int tempI = foundOrInserted(word);
        super.get(tempI).add(num);

    }


    /**
     * For each word in str, calls addWord(word, num).
     * @param str String containing all words
     * @param num Number to be passed to addWord
    */
    public void addAllWords(String str, int num)
    {
        String[] temp = str.split("\\W+");
        for (String i : temp)
        {
            if (!i.equals(""))
            {
                addWord(i, num);
            }
        }
    }
    /**
     * Tries to find an EndexEntry with a given word in this
     * DocumentIndex. If not found, inserts a new IndexEntry for
     * word at the appropriate place (in lexicographical order).
     * Returns the index of the found or inserted IndexEntry
     * @param word - word to find or insert
    */
    private int foundOrInserted(String word)
    {
        IndexEntry tempI = new IndexEntry(word);
        int temp;
        for (int i = 0; i < super.size(); i++)
        {
            temp = word.compareToIgnoreCase(super.get(i).getWord());
            if (temp == 0)
            {
                return i;
            }
            else if (temp < 0)
            {
                super.add(i, tempI);
                return i;
            }
        }
        if (super.size() > 0)
        {
            super.add(tempI);
            return (super.size() - 1);
        }
        else
        {
            super.add(tempI);
            return 0;
        }
    }

}
