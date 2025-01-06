/**
 * Given a string input, has methods to replace a given letter with hashtags, to
 * give a list of unique words with the letter in them, and to extract a word
 * from a given char Constructor initializes the text field with a string of
 * choice. When called, the mark method returns a String that is nearly
 * identitical to text but has all of the desired letter replaced with hastags.
 * the allwordswith method returns a list of unique words in text that have the
 * target letter in them. The method extractWord returns a string of the word
 * containing the character at pos within the textfield.
 * 
 * @author Rohan Chaudhary
 * @version 10-19-2024
 * @author Period - 2
 * @author Assignment - JMCh10 Lipogrammer
 * @author Sources - N/A
 */
public class LipogramAnalyzer
{
    private String text;

    /**
     * Constructor: Initializes the text field
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer(String text)
    {
        this.text = text;
    }


    /**
     * Returns a text string with all characters equal to letter replaced with
     * '#'. Do not change the 'text' field itself...
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark(char letter)
    {
        String outputString = "";
        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) != letter)
            {
                outputString += text.charAt(i);
            }
            else
            {
                outputString += "#";
            }
        }

        return outputString;
    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith(char letter)
    {
        String result = "";
        // Add all offending words.
        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == letter)
            {
                result += extractWord(i) + "\n";
            }
        }
        // System.out.println(result);

        String outputString = "";
        String tempStr;
        boolean isFail = false;
        // Remove repeats
        for (int i = 0; i < result.length(); i++)
        {
            // For every word...
            if (result.charAt(i) == '\n')
            {
                isFail = false;
                tempStr = extractWord(i - 1, result);
                // System.out.println(tempStr);
                // See if it is a repeat
                for (int j = i - tempStr.length(); j >= 0; j--)
                {
                    if (result.charAt(j) == '\n')
                    {
                        // System.out.println(extractWord(j-1,result));
                        if (tempStr.equals(extractWord(j - 1, result)))
                        {
                            isFail = true;
                            // System.out.println(extractWord(j-1,result));
                        }
                    }
                }
                if (!isFail)
                {
                    outputString += tempStr + "\n";
                }
            }
        }

        // System.out.println(outputString);

        return outputString;
    }


    // made public for test purposes
    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace OR returns the word that begins with the character at pos
     * 
     * @param pos
     *            location of a letter in text
     * @return word that contains character at pos
     */
    public String extractWord(int pos)
    {
        int startIndex = -1;
        int endIndex = -1;
        // Find the starting index.
        for (int i = pos; i >= 0; i--)
        {
            if (!Character.isLetter(text.charAt(i)))
            {
                startIndex = i + 1;
                break;
            }
            else if (i == 0)
            {
                startIndex = 0;
            }
        }

        // Find the ending index
        for (int i = pos; i < text.length(); i++)
        {
            if (!Character.isLetter(text.charAt(i)))
            {
                endIndex = i;
                break;
            }
            else if (i == text.length() - 1)
            {
                endIndex = text.length();
            }
        }

        // Create a new substring
        String outputString = (text.substring(startIndex, endIndex));
        return outputString;
    }


    /**
     * Returns the word that contains the character at pos
     * 
     * @param pos
     *            - Desired Position to find character at
     * @param input
     *            - String to Operate on
     * @return - String of the word that contains the character at position pos
     */
    private String extractWord(int pos, String input)
    {
        String text1 = input;
        int startIndex = -1;
        int endIndex = -1;
        // Find the starting index.
        for (int i = pos; i >= 0; i--)
        {
            if (!Character.isLetter(text1.charAt(i)))
            {
                startIndex = i + 1;
                break;
            }
            else if (i == 0)
            {
                startIndex = 0;
            }
        }

        // Find the ending index
        for (int i = pos; i < text1.length(); i++)
        {
            if (!Character.isLetter(text1.charAt(i)))
            {
                endIndex = i;
                break;
            }
            else if (i == text1.length() - 1)
            {
                endIndex = text1.length();
            }
        }

        // Create a new substring
        String outputString = (text1.substring(startIndex, endIndex));
        return outputString;
    }
}
