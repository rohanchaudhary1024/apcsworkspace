/**
   Implements a sorted list of words

   @author  Rohan Chaudhary
   @version 12-5-2024

   @author Period - 2
   @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order

   @author Sources - N/A
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    public SortedWordList() {
        super();
    }

    public SortedWordList(int capacity) {
        super(capacity);
    }


    public void add(int i, String word)
    {
        if ((i > 0 && word.compareToIgnoreCase(get(i-1)) <= 0) ||
                        (i < size() && word.compareToIgnoreCase(get(i)) >= 0))
            throw new IllegalArgumentException("word=" + word + " i=" + i);
        super.add(i,word);
    }

    public boolean add(String word)
    {
        int left = 0, right = size();

        while (left < right)
        {
            int middle = (left + right) / 2;
            int diff = word.compareToIgnoreCase(get(middle));

            if (diff > 0)
                left = middle + 1;
            else if (diff < 0)
                right = middle;
            else
                return false;
        }
        super.add(right, word);
        return true;
    }

    public int indexOf(Object obj) {
        //System.out.println("indexOf called");
        int bot = 0;
        int top = super.size()-1;
        int mid;
        while (bot <= top) {
            mid = (top+bot)/2;
            if (super.get(mid).equalsIgnoreCase((String)obj)) {
                return mid;
            }
            else if (super.get(mid).compareToIgnoreCase((String)obj) > 0) {
                top = mid - 1;
            }
            else if (super.get(mid).compareToIgnoreCase((String)obj) < 0) {
                bot = mid + 1;
            }
        }  

        return -1;
    }

    public boolean contains(Object obj) {
        //System.out.println("contains called");
        int bot = 0;
        int top = super.size()-1;
        int mid;

        while (bot <= top) {
            mid = (top+bot)/2;
            //System.out.println(bot + " " + mid +  " " +top);
            //System.out.println(super.get(mid));
            //System.out.println(obj);
            if (super.get(mid).equalsIgnoreCase((String)obj)) {
                return true;
            }
            else if (super.get(mid).compareToIgnoreCase((String)obj) > 0) {
                top = mid - 1;
            }
            else if (super.get(mid).compareToIgnoreCase((String)obj) < 0) {
                bot = mid + 1;
            }

        }  
        
        return false;
    }

    public String set(int i, String word) {
        if (i == 0) {
            if (word.compareToIgnoreCase(super.get(i+1)) < 0 && !(word.equals(super.get(i+1)))) {
                return super.set(i,word);
            }
            else {
                throw new IllegalArgumentException("word =" + word + " i =" + i );
            }
        }
        else if (i == super.size()-1) {
            if (word.compareToIgnoreCase(super.get(i-1)) > 0 && !(word.equals(super.get(i-1)))) {
                return super.set(i,word);
            }
            else {
                throw new IllegalArgumentException("word =" + word + " i =" + i );
            }
        }
        else {
            boolean b1 = word.compareToIgnoreCase(super.get(i+1)) < 0 && !(word.equals(super.get(i+1)));
            boolean b2 = word.compareToIgnoreCase(super.get(i-1)) > 0 && !(word.equals(super.get(i-1)));
            if (b1 && b2) {
                return super.set(i,word);
            }
            else {
                throw new IllegalArgumentException("word =" + word + " i =" + i );
            }  
        }
    }

    public void merge(SortedWordList additionalWords) {
        // 1. Count how many words in additionalWords need to be inserted into
        //    the ArrayList - i.e. how many words in additionalWords are NOT already
        //    in the ArrayList

        // 2. Save the current size of the ArrayList before growing it - you will need this in
        //    step 4

        // 3. Add this many "" words into the ArrayList

        // 4. Merge the two lists
        //  - start with the max values of each list - compare them and place the
        //    max at the end of the newly expanded array list
        //    - use an index variable for each of the lists to keep track of the position
        //      of the max of each list
        //  - repeat with the next largest values of each list until there are no more
        //    words in the additionalWord list to insert

        int wordCount = additionalWords.size();
        //System.out.println(wordCount);
        /* True
        if (additionalWords.size() > 1) {
            System.out.println(super.get(0).equalsIgnoreCase(additionalWords.get(1)));
        }
        */
        for (int i = 0; i < super.size(); i++) {
            int j = 0;
            while (j < additionalWords.size()) {
                if (super.get(i).equalsIgnoreCase(additionalWords.get(j))) {
                    //System.out.println(super.get(i) + " STAR");
                    //System.out.println(additionalWords.get(j));
                    wordCount--;
                    additionalWords.remove(j);
    
                }
                else {
                    //System.out.println(super.get(i));
                    //System.out.println(additionalWords.get(j));
                    j++;
                }
            }
        }

        //System.out.println(wordCount);

        int arrSize = super.size();
        
        for (int i = 0 ; i < wordCount; i++) {
            super.add("");
        }
        // Merge Process Debug Statementss
        String max1 = super.get(arrSize-1);
        String max2;
        int i = super.size()-1;
        int j = arrSize-1;
        while(wordCount > 0) {
            max2 = additionalWords.get(wordCount-1);
            if (j >= 0) {
                max1 = super.get(j);
                if (max2.compareToIgnoreCase(max1) > 0) {
                    //System.out.println(max2);
                    super.set(i,max2);
                    i--;
                    wordCount--;
                }
                else {
                    super.set(i,max1);
                    //System.out.println(max1);
                    i--;
                    j--;
                }
            }
            else {
                //System.out.println(max2);
                super.set(i,max2);
                i--;
                wordCount--;
            }
        }
        

    }

}
