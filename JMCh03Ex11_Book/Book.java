/**
 *  Class representing a book, with a stored current page, and total number of pages;
 *  ability to increment current page, as well as basic accessors / constructors.
 *  
 *  Two integer private fields; numPages, representing the total amount of pages; and currentPage,
 *  representing the current Page. The constructor takes in an integer input and sets numPages
 *  to that value, and setting currentPage to one by default. Accessors for all fields included
 *  within the program. Method nextPage increments currentPage by one when called if and only
 *  if currentPage is less than numPages.
 *
 *  @author  Rohan Chaudhary
 *  @version 9/13/2024
 *  @author  Period: 2
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: N/A
 */
public class Book
{
    private int numPages, currentPage;
    
    /**
     * Constructor for the book class. Sets both fields, numPages according
     * to input, currentPages to one.
     * @param inputPages The value that numPages is set to
     */
    public Book(int inputPages) {
        numPages = inputPages;
        currentPage = 1;
    }
    
    /**
     * Accessor for numPages
     * @return numPages
     */
    public int getNumPages() {
        return numPages;
    }
    
    /**
     * Accessor for currentPage
     * @return currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Increments currentPage if currentPage is less than numPage
     */
    public void nextPage() {
        if (currentPage < numPages) {
            currentPage++;
        }
    }
     
}
