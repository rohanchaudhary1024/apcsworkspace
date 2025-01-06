import java.util.Scanner;

/**
 * Converts input text to pig latin. Constructor initializes a String field,
 * which is used in the main two methods. The second main method translates an
 * individual string into pig-latin, and returns it. The first main method uses
 * the second main method to translate the entire string field, and return it.
 * it represents, and how to use it.
 * 
 * @author Rohan Chaudhary
 * @version 10/25/2024
 * @author Period - 2
 * @author Assignment - Piglatinalor
 * @author Sources - N/A
 */
public class PiglatinAnalyzer
{
    private String text;

    /**
     * Saved the input in the according field
     * @param text text to be saved
     */
    public PiglatinAnalyzer(String text)
    {
        this.text = text;
    }


    /**
     * Translates the 'text' field into a pigLatin String and returns it Each
     * word within the 'text' should be converted to pigLatin. A word ends the
     * moment there is some punctuation or white-space. Make sure to test this
     * method with the examples given in the instructions... The returned
     * translated phrase should retain all of the punctuation and white spaces
     * as the original 'text' with only the words being translated.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        String tempString = "";

        // Iterate through all characters
        for (int i = 0; i < phraseToTranslate.length(); i++)
        {
            // Check for non-alphabetical
            if (!Character.isLetter(phraseToTranslate.charAt(i)))
            {
                if (!tempString.equals(""))
                {
                    translation += wordToPigLatin(tempString);
                }
                tempString = "";
                translation += phraseToTranslate.charAt(i);
            }
            else if (i == phraseToTranslate.length() - 1)
            {
                tempString += phraseToTranslate.charAt(i);
                if (!tempString.equals(""))
                {
                    translation += wordToPigLatin(tempString);
                }
            }
            else
            {
                tempString += phraseToTranslate.charAt(i);
            }
        }

        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form using the rules below: a.
     * If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord)
    {
        String pigLatinWord = "";

        // Check for vowels
        boolean caseOne = true;
        boolean caseTwo = false;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < englishWord.length(); i++)
        {
            for (int j = 0; j < vowels.length(); j++)
            {
                if (englishWord.charAt(i) == vowels.charAt(j))
                {
                    caseOne = false;
                }
            }
        }

        if (caseOne)
        {
            pigLatinWord = englishWord + "ay";
            return pigLatinWord;
        }

        // Check for beginning with vowel
        for (int i = 0; i < vowels.length(); i++)
        {
            if (englishWord.charAt(0) == vowels.charAt(i))
            {
                caseTwo = true;
            }
        }
        if (caseTwo)
        {
            pigLatinWord = englishWord + "yay";
            return pigLatinWord;
        }

        int firstVowelIndex = -1;
        boolean isFound = false;
        // Find index of first vowel
        for (int i = 0; i < englishWord.length(); i++)
        {
            for (int j = 0; j < vowels.length(); j++)
            {
                if (englishWord.charAt(i) == vowels.charAt(j))
                {
                    isFound = true;
                    firstVowelIndex = i;
                    break;
                }
            }
            if (isFound)
            {
                break;
            }
        }

        // Derive Start and End
        String start = englishWord.substring(0, firstVowelIndex);
        String end = englishWord.substring(firstVowelIndex);

        if (Character.isUpperCase(englishWord.charAt(0)))
        {
            start = start.toLowerCase();
            end = Character.toUpperCase(end.charAt(0)) + end.substring(1);
        }

        pigLatinWord = end + start + "ay";

        return pigLatinWord;
    }
}
