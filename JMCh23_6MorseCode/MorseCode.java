import java.util.TreeMap;

/**
 * Class able to decode and encode morse code and text. Can set up a morse code
 * key and deocoding tree, encode messages, and decode messages
 * 
 * @author Rohan C
 * @version 2/7/2025
 * @author Period - 2
 * @author Assignment - Morse Code
 * @author Sources - N/A
 */
public class MorseCode
{
    private static final char                 DOT  = '.';
    private static final char                 DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode<Character>        decodeTree;

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode<Character>(' ', null, null);  // autoboxing

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }


    /**
     * Inserts a letter and its Morse code string into the encoding map and
     * calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        codeMap.put(letter, code);
        treeInsert(letter, code);
    }


    /**
     * Inserts a letter and its Morse code string into the decoding tree. Each
     * dot-dash string corresponds to a path in the tree from the root to a
     * node: at a "dot" go left, at a "dash" go right. The node at the end of
     * the path holds the symbol for that code string.
     */
    private static void treeInsert(char letter, String code)
    {
        char temp;
        TreeNode<Character> tempT = decodeTree;
        for (int i = 0; i < code.length(); i++)
        {
            temp = code.charAt(i);
            if (temp == '.')
            {
                if (tempT.getLeft() != null)
                {
                    tempT = tempT.getLeft();
                }
                else
                {
                    tempT.setLeft(new TreeNode<Character>(' ', null, null));
                    tempT = tempT.getLeft();
                }
            }
            else if (temp == '-')
            {
                if (tempT.getRight() != null)
                {
                    tempT = tempT.getRight();
                }
                else
                {
                    tempT.setRight(new TreeNode<Character>(' ', null, null));
                    tempT = tempT.getRight();
                }
            }
        }
        tempT.setValue(letter);
    }


    /**
     * Converts text into a Morse code message. Adds a space after a dot-dash
     * sequence for each letter. Other spaces in the text are transferred
     * directly into the encoded message.
     *
     * @return the encoded message.
     */
    public static String encode(String text)
    {
        StringBuffer morse = new StringBuffer(400);
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == ' ')
            {
                morse.append(" ");
            }
            else
            {
                morse.append(codeMap.get(text.charAt(i)));
                morse.append(" ");
            }
        }

        System.out.print(morse.toString());

        return morse.toString();
    }


    /**
     * Converts a Morse code message into a text string. Assumes that dot-dash
     * sequences for each letter are separated by one space. Additional spaces
     * are transferred directly into text.
     *
     * @return the plain text message.
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);
        TreeNode<Character> tempT = decodeTree;
        for (int i = 0; i < morse.length(); i++)
        {
            if (morse.charAt(i) == '.')
            {
                tempT = tempT.getLeft();
            }
            if (morse.charAt(i) == '-')
            {
                tempT = tempT.getRight();
            }
            if (morse.charAt(i) == ' ')
            {
                text.append(tempT.getValue());
                tempT = decodeTree;
            }
        }
        if (tempT.getValue() != ' ')
        {
            text.append(tempT.getValue());
        }
        System.out.print(text.toString());

        return text.toString();
    }

    // --------------------------------------------------------------------
    // For test purposes only. Not to be used in completing the assignment


    public TreeMap<Character, String> getCodeMap()
    {
        return codeMap;
    }


    public TreeNode<Character> getDecodeTree()
    {
        return decodeTree;
    }
}
